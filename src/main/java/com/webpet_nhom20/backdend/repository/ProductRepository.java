package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Integer>, JpaSpecificationExecutor<Products> {

    List<Products> findAllByCategoryId(int categoryId);
}
