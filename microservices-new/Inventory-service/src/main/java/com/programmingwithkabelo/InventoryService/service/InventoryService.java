package com.programmingwithkabelo.InventoryService.service;

import com.programmingwithkabelo.InventoryService.Repository.InventoryRepository;
import com.programmingwithkabelo.InventoryService.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
        return inventoryRepository.findBySkuCodeIn(skuCode).stream() // checks whether the object is available or not
                .map(inventory -> InventoryResponse.builder() // Missing return statement fixed here
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0) // product is in stock
                        .build()
                ).toList();
    }
}
