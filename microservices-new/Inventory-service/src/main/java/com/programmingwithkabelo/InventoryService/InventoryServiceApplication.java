package com.programmingwithkabelo.InventoryService;

import com.programmingwithkabelo.InventoryService.Repository.InventoryRepository;
import com.programmingwithkabelo.InventoryService.model.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner Loaddata(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory=new Inventory();
			inventory.setSkuCode(("Iphone-13"));
			inventory.setQuantity(100);

			Inventory inventory1=new Inventory();
			inventory1.setSkuCode(("Iphone-13-red"));
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};

	}

}
