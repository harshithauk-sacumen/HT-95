package com.sacumen.hiretalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sacumen.hiretalent.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}