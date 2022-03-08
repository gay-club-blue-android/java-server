package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    ArrayList<Product> findAllByProductCategoryId(int id);
}