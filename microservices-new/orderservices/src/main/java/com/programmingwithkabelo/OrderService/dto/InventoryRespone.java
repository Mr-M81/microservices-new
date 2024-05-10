//duplicated in the orderservices dto because we can not access it in the inventorysevice
package com.programmingwithkabelo.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryRespone{
    private String skuCode;
    private boolean isInStock;
}
