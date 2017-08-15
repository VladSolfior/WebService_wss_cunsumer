package com.vladapps.fmanager.repository;

import com.vladapps.fmanager.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 15-Aug-17.
 */

@Repository
public class DataJpaRoleRepositoryImpl implements RoleRepository {

    private CrudRoleRepository crudRoleRepository;

    @Autowired
    public DataJpaRoleRepositoryImpl(CrudRoleRepository crudRoleRepository) {
        this.crudRoleRepository = crudRoleRepository;
    }

    @Override
    public Role findByRole(String role) {
        return crudRoleRepository.findByRole(role);
    }
}
