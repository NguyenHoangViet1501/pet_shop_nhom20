package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.PermissionRequest;
import com.webpet_nhom20.backdend.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    public PermissionResponse create(PermissionRequest request);

    public List<PermissionResponse> getAll();

    public void delete(String permission);
}
