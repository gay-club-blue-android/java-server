package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoriesRepository extends JpaRepository<ProductCategory, Integer> {
}
