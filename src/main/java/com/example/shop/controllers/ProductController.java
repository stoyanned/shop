package com.example.shop.controllers;

import com.example.shop.model.Product;
import com.example.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@Controller
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showAllProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam("keyword") String keyword, Model model){
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("products", productService.searchProducts(keyword));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }
        return "index";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @PostMapping("/edit-product/{productId}")
    public String editProductForm(@PathVariable int productId, Model model) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "edit_product";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute Product updatedProduct) {
        productService.editProduct(updatedProduct.getId(), updatedProduct);
        return "redirect:/";
    }

    @PostMapping("/delete-product/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return "redirect:/";
    }
    @RequestMapping(value = "/image/{imageUrl}", method = RequestMethod.GET)
    public @ResponseBody byte[] getImage(@PathVariable String imageUrl) throws IOException {
        String imagePath = "/Users/stoyannedelchev/Desktop/Progress/images/" + imageUrl;

        InputStream in = new BufferedInputStream(new FileInputStream(imagePath));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = in.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        return buffer.toByteArray();
    }
}
