package com.programmingwithkabelo.OrderService.service;

import com.programmingwithkabelo.OrderService.dto.InventoryRespone;
import com.programmingwithkabelo.OrderService.dto.OrderLineItemsDto;
import com.programmingwithkabelo.OrderService.dto.OrderRequest;
import com.programmingwithkabelo.OrderService.model.Order;
import com.programmingwithkabelo.OrderService.model.OrderLineItems;
import com.programmingwithkabelo.OrderService.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClient;

    //take the order request which comes from controller
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());// randomizes the OrderNumber

        List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtosList()
                .stream()
                .map(this::mapToDto)
                .toList();// convert to list

        order.setOrderLineItems((orderLineItems));

       List<String> skuCodes=order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();


        // if the result is true that means you ca
        InventoryRespone[] inventoryResponesArray = webClient.build().get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("SkuCodes").build())
                .retrieve()
                .bodyToMono(InventoryRespone[].class) // by default this makes a sync request
                .block();

//creates a stream from the array
        boolean allMatch=Arrays.stream(inventoryResponesArray)
                .allMatch(InventoryRespone::isInStock);

        if(allMatch){
            //saves the order
            orderRepository.save(order);
        } else{
            throw new IllegalArgumentException("Product is not in stock");
        }

        // CALL INVENTORY SERVICE, AND PLACE ORDER If PRODUCT IS IN STOCK
        orderRepository.save((order));
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }

}
