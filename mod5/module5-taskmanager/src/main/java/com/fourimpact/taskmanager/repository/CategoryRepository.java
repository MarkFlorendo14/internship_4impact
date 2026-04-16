package com.fourimpact.taskmanager.repository;

import com.fourimpact.taskmanager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // JpaRepository already provides: findById, findAll, save, deleteById, existsById
    // Add custom methods here as needed
}
