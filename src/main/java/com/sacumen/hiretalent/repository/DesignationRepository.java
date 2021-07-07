package com.sacumen.hiretalent.repository;

import org.springframework.data.repository.CrudRepository;

import com.sacumen.hiretalent.domain.Designation;

public interface DesignationRepository extends CrudRepository<Designation, String> {

}