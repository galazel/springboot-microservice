package com.glyzel.product_service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Created product {}", product);
    }
    public List<ProductView> getAllProducts() {
        Optional<List<ProductView>> products = productRepository.findAllProjectedBy();
        if(products.isPresent())
            return products.get();
        throw new ProductException("Product not found");
    }
}
