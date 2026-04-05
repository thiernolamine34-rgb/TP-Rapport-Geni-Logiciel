package com.ecommerce.eurekaserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Cette importation est indispensable pour activer le serveur Eureka
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer; 

@SpringBootApplication
@EnableEurekaServer // <-- C'est cette annotation qui active les fonctionnalités de serveur de découverte
public class EurekaServerApplication {

    public static void main(String[] args) {
        // Cette ligne lance l'application Spring
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}

