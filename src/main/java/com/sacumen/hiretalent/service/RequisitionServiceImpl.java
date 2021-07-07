package com.sacumen.hiretalent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.Designation;
import com.sacumen.hiretalent.domain.Project;
import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.domain.Role;
import com.sacumen.hiretalent.repository.CandidateRepository;
import com.sacumen.hiretalent.repository.DesignationRepository;
import com.sacumen.hiretalent.repository.ProjectRepository;
import com.sacumen.hiretalent.repository.RequisitionRepository;
import com.sacumen.hiretalent.repository.RoleRepository;

@Transactional
@Service("requisitionService")
public class RequisitionServiceImpl implements RequisitionService {
	
	@Autowired
	private RequisitionRepository requisitionRepository;
	@Autowired
	private ProjectRepository projectRepository;	
	@Autowired
	private DesignationRepository designationRepository;
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * This method is used to retrieve the data from the table requisition based on requisitionId.
	 */
	@Override
	public Iterable<Requisition> findAllByRequisitionId(String requisitionId) {
		return requisitionRepository.findAllByRequisitionId(requisitionId);
	}	

	/**
	 * This method is to retrieve the data from the table Project.
	 */
	@Override
	public Iterable<Project> findProject() {
		return projectRepository.findAll();
	}

	/**
	 *  This method is to retrieve the data from the table Designation.
	 */
	@Override
	public Iterable<Designation> findDesignation() {
		return designationRepository.findAll();
	}

	/**
	 * This method is to save the Requisition data into the table Requisition.
	 */
	@Override
	public Requisition create(Requisition requisition) {
		return requisitionRepository.save(requisition);		
	}
	
	/**
	 *  This method is to retrieve the data from the table Candidate.
	 */
	@Override
	public Iterable<Candidate> findAll() {
		return candidateRepository.findAll();
	}
	
	/**
	 *  This method is to apply Pagination for table Candidate.
	 */
	@Override
	public Page<Candidate> requisitionList(Pageable pageable) {
		return candidateRepository.findAll(pageable);
	}	

	 /**
     * This method is used to retrieve the data from the table based on open requisition status.
     */
	@Override public Iterable<Requisition> findAll(String requisition_status ) {
		return requisitionRepository.findAll(requisition_status);
	}

	/**
     * This method is used to retrieve the data from the table based on close requisition status.
     */
	@Override 
	public Iterable<Requisition> findAllByStatus(String requisition_status) {
		return requisitionRepository.findAllByStatus(requisition_status);
	}

	 /**
     * This method is used to display the addnewprofile page.
     */
	@Override
	public Iterable<Requisition> findAllBy() {
		return requisitionRepository.findAllBy();
	}

	/**
     * This method is used to apply pagination for the status open page.
     */
	@Override
	public Page<Requisition> viewrequisitionList(org.springframework.data.domain.Pageable pageable, String requisition_status) {

		return requisitionRepository.findAll(pageable, requisition_status);
	}

	/**
     * This method is used to apply pagination for the status close page.
     */
	@Override
	public Page<Requisition> viewrequisitionListAll(org.springframework.data.domain.Pageable pageable,String requisition_status) {
		return requisitionRepository.findAllList(pageable, requisition_status);
	}

	/**
	 * This method is used to retrieve a requisition based on requisitionId
	 */
	@Override
	public Requisition findByRequisitionId(String requisitionId) {
		return requisitionRepository.findByRequisitionId(requisitionId);
	}

	/**
	 * This method is used to retrieve a list of all the requisitions 
	 */
	@Override
	public Iterable<Requisition> list() {
		return requisitionRepository.list();
	}	
	
	/**
	 * This method is to retrieve the data from the table Role.
	 */
	@Override
	public Iterable<Role> findRoles() {
		return roleRepository.findAll();
	}
}