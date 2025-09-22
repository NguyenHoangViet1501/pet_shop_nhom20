package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.response.ServicesPetResponse;

import java.util.List;


public interface ServicesPetService {
    public List<ServicesPetResponse> getActiveServices();
}
