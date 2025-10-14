package com.webpet_nhom20.backdend.service;

public interface EmailService {
    void sendHtml(String toEmail, String subject, String htmlBody);
}


