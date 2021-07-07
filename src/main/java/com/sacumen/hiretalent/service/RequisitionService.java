package com.sacumen.hiretalent.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.Designation;
import com.sacumen.hiretalent.domain.Project;
import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.domain.Role;

public interface RequisitionService {

	public Iterable<Requisition> findAllByRequisitionId(String requisitionId);
	public Iterable<Project> findProject();
	public Iterable<Designation> findDesignation();
	public Requisition create(Requisition requisition);
	public Iterable<Candidate> findAll();
	public Page<Candidate> requisitionList(Pageable pageable);
	public Iterable<Requisition> findAll(String requisition_status );
	public Iterable<Requisition> findAllByStatus(String requisition_status);
	public Iterable<Requisition> findAllBy();
	public Page<Requisition> viewrequisitionList(Pageable pageable, String requisition_status);
	public Page<Requisition> viewrequisitionListAll(Pageable pageable, String requisition_status);
	public Requisition findByRequisitionId(String requisitionId);
	public Iterable<Requisition> list();
	Iterable<Role> findRoles();
}