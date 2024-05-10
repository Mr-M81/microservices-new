package com.programmingwithkabelo.InventoryService.Repository;

import com.programmingwithkabelo.InventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);// shoud return a list of inventory objects
}
