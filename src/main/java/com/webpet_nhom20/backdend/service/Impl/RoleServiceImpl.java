package com.webpet_nhom20.backdend.service.Impl;

import com.webpet_nhom20.backdend.dto.request.Role_Permission.RoleRequest;
import com.webpet_nhom20.backdend.dto.response.RoleResponse;
import com.webpet_nhom20.backdend.mapper.RoleMapper;
import com.webpet_nhom20.backdend.repository.PermissionRepository;
import com.webpet_nhom20.backdend.repository.RoleRepository;
import com.webpet_nhom20.backdend.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {


    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;
    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
