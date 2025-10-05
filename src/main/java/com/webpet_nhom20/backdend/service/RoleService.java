package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Role_Permission.RoleRequest;
import com.webpet_nhom20.backdend.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    public RoleResponse create(RoleRequest request);

    public List<RoleResponse> getAll();

    public void delete(String role);
}
