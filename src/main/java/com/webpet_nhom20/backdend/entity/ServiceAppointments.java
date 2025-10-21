package com.webpet_nhom20.backdend.entity;

import com.webpet_nhom20.backdend.enums.AppoinmentStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceAppointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column( name = "service_id" , nullable = false)
    int serviceId;

    @Column( name = "user_id", nullable = false)
    Long userId;

    @Column( name = "name_pet", nullable = false)
    String namePet;

    @Column( name = "specie_pet", nullable = false)
    String speciePet;

    @Column( name = "appointment_start", nullable = false)
    LocalDateTime appoinmentStart;

    @Column( name = "appointment_end", nullable = false)
    LocalDateTime appoinmentEnd;

    @Enumerated(EnumType.STRING)
    @Column( name = "status", nullable = false, length = 20)
    AppoinmentStatus status = AppoinmentStatus.SCHEDULED;

    @Column( name = "notes", columnDefinition = "TEXT")
    String notes;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
