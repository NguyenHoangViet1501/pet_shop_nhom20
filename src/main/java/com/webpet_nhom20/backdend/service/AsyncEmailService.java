package com.webpet_nhom20.backdend.service;

public interface AsyncEmailService {
    public void sendAppointmentEmail(String email, String subject, String htmlBody);
}
