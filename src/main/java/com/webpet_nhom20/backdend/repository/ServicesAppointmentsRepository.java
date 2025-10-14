package com.webpet_nhom20.backdend.repository;

import com.webpet_nhom20.backdend.entity.ServiceAppointments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesAppointmentsRepository extends JpaRepository<ServiceAppointments,Integer> {
    // CUSTOMER: lấy theo userId, ưu tiên SCHEDULED, rồi sắp theo appoinmentStart tăng dần
    @Query("""
           SELECT s FROM ServiceAppointments s 
           WHERE s.userId = :userId 
           ORDER BY 
             CASE WHEN s.status = 'SCHEDULED' THEN 0 ELSE 1 END,
             s.appoinmentStart ASC
           """)
    Page<ServiceAppointments> findByUserIdOrderByStatusAndStart(Integer userId, Pageable pageable);

    // ADMIN: lấy tất cả, ưu tiên SCHEDULED, rồi theo thời gian gần nhất
    @Query("""
           SELECT s FROM ServiceAppointments s
           ORDER BY 
             CASE WHEN s.status = 'SCHEDULED' THEN 0 ELSE 1 END,
             s.appoinmentStart ASC
           """)
    Page<ServiceAppointments> findAllOrderByStatusAndStart(Pageable pageable);
}

