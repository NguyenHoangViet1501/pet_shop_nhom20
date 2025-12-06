package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Integer>, JpaSpecificationExecutor<Products> {
    boolean existsByName(String name);
    List<Products> findAllByCategoryId(int categoryId);

    Page<Products> findByCategoryId(int categoryId, Pageable pageable);
    Page<Products> findByCategoryIdAndNameContainingIgnoreCase(int categoryId, String name , Pageable pageable);

    Page<Products> findByNameContainingIgnoreCase(String name , Pageable pageable);
    @Query(value = "SELECT DISTINCT p.* FROM products p " +
            "INNER JOIN product_variants v ON p.id = v.product_id " +
            "WHERE v.price BETWEEN :minPrice AND :maxPrice",
            countQuery = "SELECT COUNT(DISTINCT p.id) FROM products p " +
                    "INNER JOIN product_variant v ON p.id = v.product_id " +
                    "WHERE v.price BETWEEN :minPrice AND :maxPrice",
            nativeQuery = true)
    Page<Products> findByPriceBetween(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, Pageable pageable);

    // 2. Category + Giá
    @Query(value = "SELECT DISTINCT p.* FROM products p " +
            "INNER JOIN product_variants v ON p.id = v.product_id " +
            "WHERE p.category_id = :categoryId AND v.price BETWEEN :minPrice AND :maxPrice",
            countQuery = "SELECT COUNT(DISTINCT p.id) FROM products p " +
                    "INNER JOIN product_variant v ON p.id = v.product_id " +
                    "WHERE p.category_id = :categoryId AND v.price BETWEEN :minPrice AND :maxPrice",
            nativeQuery = true)
    Page<Products> findByCategoryIdAndPriceBetween(@Param("categoryId") int categoryId, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, Pageable pageable);

    // 3. Tên + Giá
    @Query(value = "SELECT DISTINCT p.* FROM products p " +
            "INNER JOIN product_variants v ON p.id = v.product_id " +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) AND v.price BETWEEN :minPrice AND :maxPrice",
            countQuery = "SELECT COUNT(DISTINCT p.id) FROM products p " +
                    "INNER JOIN product_variant v ON p.id = v.product_id " +
                    "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) AND v.price BETWEEN :minPrice AND :maxPrice",
            nativeQuery = true)
    Page<Products> findByNameContainingIgnoreCaseAndPriceBetween(@Param("name") String name, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, Pageable pageable);

    // 4. Category + Tên + Giá
    @Query(value = "SELECT DISTINCT p.* FROM products p " +
            "INNER JOIN product_variants v ON p.id = v.product_id " +
            "WHERE p.category_id = :categoryId AND LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) AND v.price BETWEEN :minPrice AND :maxPrice",
            countQuery = "SELECT COUNT(DISTINCT p.id) FROM products p " +
                    "INNER JOIN product_variant v ON p.id = v.product_id " +
                    "WHERE p.category_id = :categoryId AND LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) AND v.price BETWEEN :minPrice AND :maxPrice",
            nativeQuery = true)
    Page<Products> findByCategoryIdAndNameContainingIgnoreCaseAndPriceBetween(@Param("categoryId") int categoryId, @Param("name") String name, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, Pageable pageable);

}
