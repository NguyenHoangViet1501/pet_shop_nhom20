package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.ServicesPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesPetRespository extends JpaRepository<ServicesPet,Integer> {
    List<ServicesPet> findByIsActive(String isActive);

}
