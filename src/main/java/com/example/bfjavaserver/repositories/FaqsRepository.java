package com.example.bfjavaserver.repositories;

import com.example.bfjavaserver.models.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqsRepository extends JpaRepository<Faq, Integer> {
}