package ru.netology.jdbc.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.jdbc.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String name) {
        String productName = service.getProductName(name);
        System.out.println("Клиент по имени " + name + " купил продукт под названием " + productName);

        return productName;
    }
}
