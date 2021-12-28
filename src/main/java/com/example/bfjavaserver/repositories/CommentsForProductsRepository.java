package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.CommentForProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsForProductsRepository extends JpaRepository<CommentForProduct, Integer> {
}