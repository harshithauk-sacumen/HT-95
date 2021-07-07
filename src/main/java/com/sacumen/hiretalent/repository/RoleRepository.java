package com.sacumen.hiretalent.repository;

import org.springframework.data.repository.CrudRepository;
import com.sacumen.hiretalent.domain.Role;

public interface RoleRepository extends CrudRepository<Role,String> {

}