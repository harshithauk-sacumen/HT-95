package com.sacumen.hiretalent.repository;

import org.springframework.data.repository.CrudRepository;

import com.sacumen.hiretalent.domain.Project;

public interface ProjectRepository extends CrudRepository<Project, String>{
}