package com.sacumen.hiretalent.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.SourceType;

public interface CandidateService {

	public Iterable<Candidate> findAll(String requisition_id);
	public Long countByRequisitionId(String requisition_id);
	public Long countByL1(String requisition_id); 
	public Long countByL2(String requisition_id); 
	public Long countByL3(String requisition_id); 
	public Iterable<SourceType> findAllSourceTypes();
	public Candidate saveCandidate(Candidate candidate, MultipartFile file) throws IOException;
	public Optional<Candidate> getFile(String fileId);
	public Iterable<Candidate> getFiles();
}