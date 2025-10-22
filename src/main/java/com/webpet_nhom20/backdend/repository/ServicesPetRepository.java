package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Categories;
import com.webpet_nhom20.backdend.entity.ServicesPet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesPetRepository extends JpaRepository<ServicesPet,Integer>, JpaSpecificationExecutor<ServicesPet> {
    List<ServicesPet> findByIsActive(String isActive);
    Page<ServicesPet> findByNameContainingIgnoreCase(String name , Pageable pageable);
    List<ServicesPet> findByTitle(String title);
    boolean existsByName(String name);

}
