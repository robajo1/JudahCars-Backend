package com.example.JudahCars_Backend.Service;

import com.example.JudahCars_Backend.DTO.ProductCreateDTO;
import com.example.JudahCars_Backend.DTO.ProductSearchDTO;
import com.example.JudahCars_Backend.DTO.ProductSpecification;
import com.example.JudahCars_Backend.DTO.ProductUpdateDTO;
import com.example.JudahCars_Backend.Exception.ResourceNotFoundException;
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
        System.out.println("max: "+searchDTO.getMaxPrice());
        System.out.println("min: "+searchDTO.getMinPrice());
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
                .orElseThrow(() -> new ResourceNotFoundException("Seller not found"));


        product.setSeller(seller);


        repo.save(product);
    }

    public void removeProduct(int id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        repo.delete(product);
    }

    public Product updateProduct(int id, ProductUpdateDTO dto) {

        Product product = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (dto.getType() != null && !dto.getType().isEmpty()) product.setType(dto.getType());
        if (dto.getMake() != null && !dto.getMake().isEmpty()) product.setMake(dto.getMake());
        if (dto.getModel() != null && !dto.getModel().isEmpty()) product.setModel(dto.getModel());
        if (dto.getYear() != null) product.setYear(dto.getYear());
        if (dto.getPrice() != null) product.setPrice(dto.getPrice());
        if (dto.getMileage() != null) product.setMileage(dto.getMileage());
        if (dto.getFuelType() != null && !dto.getFuelType().isEmpty()) product.setFuelType(dto.getFuelType());
        if (dto.getTransmission() != null && !dto.getTransmission().isEmpty()) product.setTransmission(dto.getTransmission());
        if (dto.getDescription() != null && !dto.getDescription().isEmpty()) product.setDescription(dto.getDescription());
        if (dto.getLocation() != null && !dto.getLocation().isEmpty()) product.setLocation(dto.getLocation());
        if (dto.getImageUrl1() != null && !dto.getImageUrl1().isEmpty()) product.setImageUrl1(dto.getImageUrl1());
        if (dto.getImageUrl2() != null && !dto.getImageUrl2().isEmpty()) product.setImageUrl2(dto.getImageUrl2());
        if (dto.getImageUrl3() != null && !dto.getImageUrl3().isEmpty()) product.setImageUrl3(dto.getImageUrl3());
        if (dto.getSketchfabEmbed() != null && !dto.getSketchfabEmbed().isEmpty()) product.setSketchfabEmbed(dto.getSketchfabEmbed());

        repo.save(product);
        return product;
    }

    public List<Product> searchSellerProducts(Integer sellerid) {
        if (!userRepo.existsById(sellerid)) {
            throw new ResourceNotFoundException("Seller not found");
        }
        return repo.findAllBySeller_UserId(sellerid);
    }
}
