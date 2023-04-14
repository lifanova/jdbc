package ru.netology.jdbc.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.jdbc.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String name) {
        List<String> list = service.getProductName(name);

        return list;
    }
}
