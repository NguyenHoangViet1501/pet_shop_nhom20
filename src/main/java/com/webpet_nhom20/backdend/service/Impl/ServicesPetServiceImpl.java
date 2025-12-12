package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.ServicePet.CreateServicePetRequest;
import com.webpet_nhom20.backdend.dto.request.ServicePet.UpdateServicePetRequest;
import com.webpet_nhom20.backdend.dto.response.ServicePet.ServicesPetResponse;
import com.webpet_nhom20.backdend.entity.ServicesPet;
import com.webpet_nhom20.backdend.exception.AppException;
import com.webpet_nhom20.backdend.exception.ErrorCode;
import com.webpet_nhom20.backdend.mapper.ServicesPetMapper;
import com.webpet_nhom20.backdend.repository.ServicesPetRepository;
import com.webpet_nhom20.backdend.service.ServicesPetService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicesPetServiceImpl implements ServicesPetService {

    @Autowired
    private final ServicesPetRepository servicesPetRepository;

    @Autowired
    private final ServicesPetMapper servicesPetMapper;

    @Override
    public Page<ServicesPetResponse> getAllServices(String search, Pageable pageable){
        if(search == null || search.trim().isEmpty()){
            return servicesPetRepository.findAll(pageable).map(servicesPetMapper::toServicesPetResponse);
        }
        return servicesPetRepository.findByNameContainingIgnoreCase(search,pageable).map(servicesPetMapper::toServicesPetResponse);
    }

    @Override
    public ServicesPetResponse getServiceById(int serviceId) {
        ServicesPet servicesPet = servicesPetRepository.findById(serviceId).orElseThrow(()-> new AppException(ErrorCode.SERVICE_NOT_FOUND));
        return servicesPetMapper.toServicesPetResponse(servicesPet);
    }

    @Override
    public List<ServicesPetResponse> getActiveServices() {
        return servicesPetRepository.findByIsActive("1")
                .stream()
                .map(servicesPetMapper::toServicesPetResponse)
                .collect(Collectors.toList());
    }
    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ServicesPetResponse createServicesPet(CreateServicePetRequest request){
        ServicesPet servicesPet = servicesPetMapper.toServicePet(request);
        return servicesPetMapper.toServicesPetResponse(servicesPetRepository.save(servicesPet));
    }



    @PreAuthorize("hasRole('SHOP')")
    @Override
    public ServicesPetResponse updateServicesPet(int servicePetId ,UpdateServicePetRequest request){
        ServicesPet servicesPet = servicesPetRepository.findById(servicePetId).orElseThrow(()-> new AppException(ErrorCode.SERVICE_NOT_FOUND));
        servicesPetMapper.updateServicePet(servicesPet,request);
        return servicesPetMapper.toServicesPetResponse(servicesPetRepository.save(servicesPet));
    }

}
