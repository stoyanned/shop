package com.example.shop.controllers;

import com.example.shop.model.Order;
import com.example.shop.model.Product;
import com.example.shop.services.CartService;
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
    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
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
}
