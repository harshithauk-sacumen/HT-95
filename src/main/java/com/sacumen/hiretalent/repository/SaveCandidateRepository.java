package com.sacumen.hiretalent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.sacumen.hiretalent.domain.Candidate;

/**
 * This method is used to apply the pagination .
 * @param pageable
 */
public interface SaveCandidateRepository extends PagingAndSortingRepository<Candidate,Long> {

	public Page<Candidate> findAll(Pageable pageable);
}