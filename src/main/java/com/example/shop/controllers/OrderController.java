package com.example.shop.controllers;

import com.example.shop.model.Order;
import com.example.shop.services.CartService;
import com.example.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;

    @Autowired
    public OrderController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

//    @Transactional
//    @PostMapping("/place-order1")
//    public String placeOrder(@RequestParam String name, @RequestParam String email, @RequestParam String address){
//        Order order = cartService.createOrder(name, email, address);
//        orderService.saveOrder(order);
//        cartService.clearCart();
//        return "redirect:/order-confirmation?orderId=" + order.getId();
//    }

    @GetMapping("/order-confirmation")
    public String showOrderConfirmation(@RequestParam int orderId, Model model){
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            model.addAttribute("name", order.getName());
            model.addAttribute("email", order.getEmail());
        }
//        else {
//            model.addAttribute("errorMessage", "Order not found or is null");
//        }

        return "order_confirmation";
    }

    @GetMapping("/order-history")
    public String showOrderHistory(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        List<Order> orderHistory = orderService.getOrdersByEmail(email);
        model.addAttribute("orderHistory", orderHistory);
        return "order_history";
    }

}
