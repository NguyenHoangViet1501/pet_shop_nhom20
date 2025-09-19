package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.ServiceAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceAppointmentsRepository extends JpaRepository<ServiceAppointments,Integer> {
}
