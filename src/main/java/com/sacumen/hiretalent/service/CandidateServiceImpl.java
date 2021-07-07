package com.sacumen.hiretalent.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.SourceType;
import com.sacumen.hiretalent.repository.CandidateRepository;
import com.sacumen.hiretalent.repository.SourceTypeRepository;

@Transactional
@Service("candidateService")
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private SourceTypeRepository sourceTypeRepository;

	/**
	 * This method is used to retrieve a candidate based on the most recent offered_date from the table candidate for a requisitionId.
	 */
	@Override 
	public Iterable<Candidate> findAll(String requisition_id) {
		return candidateRepository.findAll(requisition_id);
	}

	/**
	 * This method is used to count the number of candidates sourced from the table candidate for a requisitionId.
	 */
	@Override
	public Long countByRequisitionId(String requisition_id){ 
		return candidateRepository.countByRequisitionId(requisition_id); 
	}

	/**
	 * This method is used to count the number of candidates for level number 1 from the table candidate for a requisitionId.
	 */
	@Override
	public Long countByL1(String requisition_id)
	{
		return candidateRepository.countByL1(requisition_id);
	}

	/**
	 * This method is used to count the number of candidates for level number 2 from the table candidate for a requisitionId.
	 */
	@Override
	public Long countByL2(String requisition_id)
	{
		return candidateRepository.countByL2(requisition_id);
	}

	/**
	 * This method is used to count the number of candidates for level number 3 from the table candidate for a requisitionId.
	 */
	@Override
	public Long countByL3(String requisition_id)
	{
		return candidateRepository.countByL3(requisition_id);
	}	

	/**
	 * This method is to save the Candidate data into the table Candidate.
	 */
	@Override
	public Candidate saveCandidate(Candidate candidate, MultipartFile file) throws IOException {
		candidate.setDocName(file.getOriginalFilename());
		candidate.setDocType(file.getContentType());
		candidate.setData(file.getBytes());
		return candidateRepository.save(candidate);		
	}

	/**
	 * This method is used to retrieve all the data from the table SourceType.
	 */
	@Override
	public Iterable<SourceType> findAllSourceTypes() {
		return sourceTypeRepository.findAll();
	}

	/**
	 * This method is used to retrieve the data from the table Candidate based on the Id.
	 */
	@Override
	public Optional<Candidate> getFile(String candidateId) {
		  return candidateRepository.findById(candidateId);
	  }

	/**
	 * This method is used to retrieve all the data from the table Candidate.
	 */
	@Override
	public Iterable<Candidate> getFiles() {
		 return candidateRepository.findAll();
	}
}