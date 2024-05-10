package com.programmingwithkabelo.InventoryService.Controller;

import com.programmingwithkabelo.InventoryService.dto.InventoryResponse;
import com.programmingwithkabelo.InventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    //http:/localhost:8082/api/inventory/iphone-13, iphone13-red-red
    //http:/localhost:8082/api/inventory/skuCode=iphone-13, sku-code=iphone13-red-red


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
