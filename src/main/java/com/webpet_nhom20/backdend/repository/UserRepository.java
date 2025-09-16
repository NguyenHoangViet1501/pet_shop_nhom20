package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
