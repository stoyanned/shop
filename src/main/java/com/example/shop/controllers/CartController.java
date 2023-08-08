package com.example.shop.controllers;

import com.example.shop.model.Order;
import com.example.shop.model.Product;
import com.example.shop.services.CartService;
import com.example.shop.services.OrderService;
import com.example.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController{
    private final CartService cartService;
    private final ProductService productService;
    private final OrderService orderService;
    @Autowired
    public CartController(CartService cartService, ProductService productService, OrderService orderService) {
        this.cartService = cartService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("totalPrice", cartService.getTotalPrice());
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Integer productId, @RequestParam int quantity) {
        Product product = productService.getProductById(productId);
        cartService.addToCart(product, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/update-cart")
    public String updateCartItem(@RequestParam int cartItemId, @RequestParam int quantity) {
        cartService.updateCartItemQuantity(cartItemId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove-from-cart")
    public String removeCartItem(@RequestParam int cartItemId) {
        cartService.removeCartItem(cartItemId);
        return "redirect:/cart";
    }

    @PostMapping("/clear-cart")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

    @PostMapping("/place-order")
    public String placeOrder(@RequestParam String name, @RequestParam String email, @RequestParam String address) {
        Order order = cartService.createOrder(name, email, address);
        cartService.clearCart();
        return "redirect:/order-confirmation?orderId=" + order.getId();
    }


//    @PostMapping("/place-order")
//    public String placeOrder(@RequestParam String name, @RequestParam String email, @RequestParam String address) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MyUserPrincipal userPrincipal = (MyUserPrincipal) authentication.getPrincipal();
//
//        Order order = cartService.createOrder(name, email, address);
//        order.setUser(userPrincipal.getUsername()); // Assuming there's a getUser() method in MyUserPrincipal
//        orderService.saveOrder(order);
//
//        cartService.clearCart();
//        return "redirect:/order-confirmation?orderId=" + order.getId();
//    }


}
