package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
}