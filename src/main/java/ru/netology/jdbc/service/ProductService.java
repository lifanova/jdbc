package ru.netology.jdbc.service;

import org.springframework.stereotype.Service;
import ru.netology.jdbc.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) {
        return repository.getProductName(name);
    }
}
