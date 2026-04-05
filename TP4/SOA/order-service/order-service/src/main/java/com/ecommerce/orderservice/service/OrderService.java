package com.ecommerce.orderservice.service; 
import com.ecommerce.orderservice.client.ProductClient; 
import com.ecommerce.orderservice.dto.ProductDTO; 
import com.ecommerce.orderservice.model.Order; 
import com.ecommerce.orderservice.repository.OrderRepository; 
import lombok.RequiredArgsConstructor; 
import org.springframework.stereotype.Service; 
import java.time.LocalDateTime; 
import java.util.List; 
@Service 
@RequiredArgsConstructor 
public class OrderService { 
  private final OrderRepository orderRepository; 
  private final ProductClient productClient; 
  public List < Order > getAllOrders() { 
    return orderRepository.findAll(); 
  } 
  public Order createOrder(Long productId, Integer quantity) { 
    // 1. Récupérer les infos du produit (tu l'as déjà fait)
    ProductDTO product = productClient.getProductById(productId); 
    
    // 2. AJOUT : Appeler le client Feign pour réduire le stock
    // Si le stock est insuffisant, une exception sera levée ici et le code s'arrêtera
    productClient.reduceStock(productId, quantity);

    // 3. Créer la commande (ton code existant)
    Order order = new Order(); 
    order.setProductId(productId); 
    order.setProductName(product.getName()); 
    order.setQuantity(quantity); 
    order.setTotalPrice(product.getPrice() * quantity); 
    order.setOrderDate(LocalDateTime.now()); 
    order.setStatus("CREATED"); // On peut passer de PENDING à CREATED car le stock est validé
    
    return orderRepository.save(order); 
  } 
} 