package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Categories,Integer> , JpaSpecificationExecutor<Categories> {
    boolean existsByName(String name);
}
