package com.example.proxyandcglib.module.service;

import com.example.proxyandcglib.module.model.Role;

public interface RoleService {
    void add(Role role);

    Role get(long id);

    void save(Role role);
}
