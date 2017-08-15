package com.vladapps.fmanager.repository;

import com.vladapps.fmanager.model.Role;

/**
 * Created by vlad on 15-Aug-17.
 */


public interface RoleRepository {
    Role findByRole(String role);
}

