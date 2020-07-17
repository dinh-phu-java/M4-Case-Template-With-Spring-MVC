package com.dinhphu.services.role;

import com.dinhphu.model.UserRole;
import com.dinhphu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices implements IRoleServices{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserRole> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public UserRole findById(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public UserRole update(UserRole model) {
        return null;
    }

    @Override
    public UserRole deleteModel(Integer id) {
        return null;
    }
}
