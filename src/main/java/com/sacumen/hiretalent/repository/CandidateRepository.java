package com.sacumen.hiretalent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sacumen.hiretalent.domain.Candidate;

@Repository("candidateRepository")
public interface CandidateRepository extends CrudRepository<Candidate,String>{	

	/**
	 * This method is used to count the number of candidates sourced from the table candidate for a requisitionId.
	 * @param requisitionId
	 * @return
	 */
	@Query(value ="select count(*) from mydb2schema.candidate c where c.requisition_id = :requisitionId",nativeQuery = true) 
	public Long countByRequisitionId(@Param("requisitionId") String requisitionId);


	/**
	 * This method is used to count the number of candidates for level number 1 from the table candidate for a requisitionId.
	 * @param requisitionId
	 * @return
	 */
	@Query(value ="select count(*) from mydb2schema.candidate c where c.requisition_id = :requisitionId and c.level_number = 1",nativeQuery = true) 
	public Long countByL1(@Param("requisitionId") String requisitionId); 

	/**
	 * This method is used to count the number of candidates for level number 2 from the table candidate for a requisitionId.
	 * @param requisitionId
	 * @return
	 */
	@Query(value ="select count(*) from mydb2schema.candidate c where c.requisition_id = :requisitionId and c.level_number = 2",nativeQuery = true) 
	public Long countByL2(@Param("requisitionId") String requisitionId);

	/**
	 * This method is used to count the number of candidates for level number 3 from the table candidate for a requisitionId.
	 * @param requisitionId
	 * @return
	 */
	@Query(value ="select count(*) from mydb2schema.candidate c where c.requisition_id = :requisitionId and c.level_number=3",nativeQuery = true) 
	public Long countByL3(String requisitionId);

	/**
	 * This method is used to retrieve a candidate based on the most recent offered_date  from the table candidate for a requisitionId.
	 * @param requisitionId
	 * @return
	 */
	@Query(value ="select * from mydb2schema.candidate c where c.requisition_id = :requisitionId and c.offered_date = (select max(offered_date) from mydb2schema.candidate)",nativeQuery = true) 
	public Iterable<Candidate> findAll(@Param("requisitionId") String requisitionId);

	/**
	 * This method is used to apply the pagination .
	 * @param pageable
	 */
	public Page<Candidate> findAll(Pageable pageable);
}