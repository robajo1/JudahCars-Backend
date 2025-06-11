package com.example.JudahCars_Backend.config;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager manager = new CaffeineCacheManager("searchProducts", "sellerProducts");
        manager.setCaffeine(
                Caffeine.newBuilder()
                        .expireAfterWrite(30, TimeUnit.MINUTES) // Cache entries(items) expire after 10 minutes
                        .maximumSize(500) // Limit to 500 entries(items) to avoid memory issues
        );
        return manager;
    }
}
