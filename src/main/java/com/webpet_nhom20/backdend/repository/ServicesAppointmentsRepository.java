package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.ServiceAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesAppointmentsRepository extends JpaRepository<ServiceAppointments,Integer> {
    @Query("""
        SELECT sa
        FROM ServiceAppointments sa
        WHERE sa.userId = :userId
          AND sa.status = 'SCHEDULED'
        ORDER BY sa.appoinmentStart ASC
    """)
    List<ServiceAppointments> findScheduledAppointmentsByUserId(Integer userId);
}
