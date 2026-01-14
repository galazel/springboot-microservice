package com.glyzel.product_service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.ListView;
import java.util.List;
import java.util.Optional;

interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<List<ProductView>> findAllProjectedBy();
}
