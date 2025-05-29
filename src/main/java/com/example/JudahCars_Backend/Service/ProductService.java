package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.DTO.ProductCreateDTO;
import com.example.JudahCars_Backend.DTO.ProductSearchDTO;
import com.example.JudahCars_Backend.DTO.ProductSpecification;
import com.example.JudahCars_Backend.DTO.ProductUpdateDTO;
import com.example.JudahCars_Backend.Model.Product;
import com.example.JudahCars_Backend.Model.Users;
import com.example.JudahCars_Backend.Repository.ProductRepo;
import com.example.JudahCars_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    @Autowired
    private UserRepo userRepo;


    public List<Product> searchProducts(ProductSearchDTO searchDTO) {
        Specification<Product> spec = ProductSpecification.getProductsByFilter(searchDTO);
        return repo.findAll(spec);
    }

    public void addProduct(ProductCreateDTO dto) {

        Product product = new Product();
        product.setType(dto.getType());
        product.setMake(dto.getMake());
        product.setModel(dto.getModel());
        product.setYear(dto.getYear());
        product.setPrice(dto.getPrice());
        product.setMileage(dto.getMileage());
        product.setFuelType(dto.getFuelType());
        product.setTransmission(dto.getTransmission());
        product.setDescription(dto.getDescription());
        product.setLocation(dto.getLocation());
        product.setImageUrl1(dto.getImageUrl1());
        product.setImageUrl2(dto.getImageUrl2());
        product.setImageUrl3(dto.getImageUrl3());
        product.setSketchfabEmbed(dto.getSketchfabEmbed());

        Users seller = userRepo.findById(dto.getSellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));
        product.setSeller(seller);
        repo.save(product);
    }

    public void removeProduct(int id) {
        repo.deleteById(id);
    }


    public void updateProduct(int id, ProductUpdateDTO dto) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (dto.getType() != null)product.setType(dto.getType());
        if (dto.getMake() != null) product.setMake(dto.getMake());
        if (dto.getModel() != null) product.setModel(dto.getModel());
        if (dto.getYear() != null) product.setYear(dto.getYear());
        if (dto.getPrice() != null) product.setPrice(dto.getPrice());
        if (dto.getMileage() != null) product.setMileage(dto.getMileage());
        if (dto.getFuelType() != null) product.setFuelType(dto.getFuelType());
        if (dto.getTransmission() != null) product.setTransmission(dto.getTransmission());
        if (dto.getDescription() != null) product.setDescription(dto.getDescription());
        if (dto.getLocation() != null) product.setLocation(dto.getLocation());
        if (dto.getImageUrl1() != null) product.setImageUrl1(dto.getImageUrl1());
        if (dto.getImageUrl2() != null) product.setImageUrl2(dto.getImageUrl2());
        if (dto.getImageUrl3() != null) product.setImageUrl3(dto.getImageUrl3());
        if (dto.getSketchfabEmbed() != null) product.setSketchfabEmbed(dto.getSketchfabEmbed());

        repo.save(product);
    }

    public List<Product> searchSellerProducts(Integer sellerid) {
       return repo.findAllBySeller_UserId(sellerid);
    }
}
