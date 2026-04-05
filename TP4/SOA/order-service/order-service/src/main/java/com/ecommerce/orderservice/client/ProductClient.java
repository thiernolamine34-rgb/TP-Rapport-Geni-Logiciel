package com.ecommerce.orderservice.client; 

import com.ecommerce.orderservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")  
public interface ProductClient { 
    
    @GetMapping("/api/products/{id}") 
    ProductDTO getProductById(@PathVariable("id") Long id); 

    // CETTE MÉTHODE DOIT ÊTRE ICI (AVANT LE DERNIER })
    @PutMapping("/api/products/{id}/reduce-stock")
    void reduceStock(@PathVariable("id") Long id, @RequestParam("quantity") int quantity);

} // L'accolade doit être à la toute fin