package com.programmingwithkabelo.OrderService.Controller;

import com.programmingwithkabelo.OrderService.dto.OrderRequest;
import com.programmingwithkabelo.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeHolder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest); // when user places order
    return "Order Placed sucessfully";
    }
}
