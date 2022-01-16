package com.example.spring_boot_rest.repository;

import com.example.spring_boot_rest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
