package com.thiTN.webthitracnghiem.service.impl;

import com.thiTN.webthitracnghiem.model.Role;
import com.thiTN.webthitracnghiem.repository.RoleRepository;
import com.thiTN.webthitracnghiem.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByRoleName(roleName).orElse(null);
    }
}
