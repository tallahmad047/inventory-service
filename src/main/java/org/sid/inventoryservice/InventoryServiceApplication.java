package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Produit;
import org.sid.inventoryservice.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner (ProduitRepository repository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Produit.class);
        return  args -> {
          repository.saveAll(
                  List.of(
                          Produit.builder().name("Shakoff").price(24760).quantity(23).build(),
                          Produit.builder().name("Splina").price(24760).quantity(23).build(),
                          Produit.builder().name("Troika").price(1060).quantity(23).build(),
                          Produit.builder().name("ginseng").price(12760).quantity(23).build(),
                          Produit.builder().name("redyeast").price(12760).quantity(23).build()
                  )
          )  ;
          repository.findAll().forEach(p->{
              System.out.println(p);
          });
        };
    }

}
