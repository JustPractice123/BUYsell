package com.example.BUYsell.Repositories;

import com.example.BUYsell.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByTitle(String title);
}
