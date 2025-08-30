package com.example.marketplace_monolith.service;

import com.example.marketplace_monolith.entity.Product;
import com.example.marketplace_monolith.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAll() {
        log.info("[Tech][Info] Getting all products");
        return repository.findAll();
    }

    public Optional<Product> getById(String id) {
        log.info("[Tech][Info] Getting product by id: {}", id);
        return repository.findById(id);
    }

    public Product create(Product product) {
        log.info("[Tech][Info] Created product with parameters: {}", product.toString());
        return repository.save(product);
    }

    public Optional<Product> update(String id, Product updatedProduct) {
        Optional<Product> oldProduct = repository.findById(id);

        if (oldProduct.isPresent()) {
            updatedProduct.setId(id);
            log.info("[Tech][Info] Updated product with id {} and parameters {}", id, updatedProduct);
            return Optional.of(repository.save(updatedProduct));
        }

        log.info("[Tech][Info] Can not find product with id: {}", id);
        return Optional.empty();
    }

    public void deleteById(String id) {
        log.info("[Tech][Info] Deleted product with id: {}", id);
        repository.deleteById(id);
    }

    // getAllByCategory
    // etc...

}
