package com.ecommerce.orderservice.controller; 

import com.ecommerce.orderservice.model.Order; 
import com.ecommerce.orderservice.service.OrderService; 
import lombok.Data;
import lombok.RequiredArgsConstructor; 
import org.springframework.web.bind.annotation.*; 
import java.util.List; 
@RestController  
@RequestMapping("/api/orders")  
@RequiredArgsConstructor  
public class OrderController { 
    private final OrderService orderService; 
    @GetMapping 
    public List<Order> getAllOrders() { 
        return orderService.getAllOrders(); 
    } 
    // CORRECTION : On utilise @RequestBody avec un objet DTO
    @PostMapping 
    public Order createOrder(@RequestBody OrderRequest request) { 
        return orderService.createOrder(request.getProductId(), request.getQuantity()); 
    } 
    // Cette classe permet de mapper le JSON de Postman
    @Data
    public static class OrderRequest {
        private Long productId;
        private Integer quantity;
    }
}