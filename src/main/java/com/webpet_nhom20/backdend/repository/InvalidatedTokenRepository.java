package com.webpet_nhom20.backdend.repository;


import com.webpet_nhom20.backdend.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {}
