package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.response.ServicesPetResponse;
import com.webpet_nhom20.backdend.mapper.ServicesPetMapper;
import com.webpet_nhom20.backdend.repository.ServicesPetRespository;
import com.webpet_nhom20.backdend.service.ServicesPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicesPetServiceImpl implements ServicesPetService {

    @Autowired
    private final ServicesPetRespository servicesPetRespository;

    @Autowired
    private final ServicesPetMapper servicesPetMapper;

    @Override
    public List<ServicesPetResponse> getActiveServices() {
        return servicesPetRespository.findByIsActive("1")
                .stream()
                .map(servicesPetMapper::toServicesPetResponse)
                .collect(Collectors.toList());
    }
}
