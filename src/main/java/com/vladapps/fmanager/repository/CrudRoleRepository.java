package com.vladapps.fmanager.repository;

import com.vladapps.fmanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vlad on 15-Aug-17.
 */
@Transactional(readOnly = true)
public interface CrudRoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
