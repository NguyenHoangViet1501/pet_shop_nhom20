package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.Addresses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Addresses, Integer> {
    Page<Addresses> findAllByUserIdAndIsDeleted(Integer userId, String isDeleted, Pageable pageable);

    List<Addresses> findByUserId(Integer userId);


    List<Addresses> findByUserIdAndIsDeleted(Integer userId, String s);
}
