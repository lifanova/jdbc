package ru.netology.jdbc.service;

import org.springframework.stereotype.Service;
import ru.netology.jdbc.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<String> getProductName(String name) {
        return repository.getProductName(name);
    }
}
