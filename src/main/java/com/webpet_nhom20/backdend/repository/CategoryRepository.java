package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Categories,Integer> , JpaSpecificationExecutor<Categories> {
    boolean existsByName(String name);

    Page<Categories> findByNameContainingIgnoreCase(String name , Pageable pageable);

    @Query(value = "SELECT * From categories where is_featured = :isFeature", nativeQuery = true)
    Page<Categories> filterByFeature(@Param("isFeature") String isFeature, Pageable pageable);
}
