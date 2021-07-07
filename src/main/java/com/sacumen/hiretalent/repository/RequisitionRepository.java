package com.sacumen.hiretalent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sacumen.hiretalent.domain.Requisition;

@Repository("requisitionRepository")
public interface RequisitionRepository extends CrudRepository<Requisition,String> {

	/**
	 * This method is used to retrieve the data from the table requisition based on requisitionId.
	 * @param requisitionId
	 * @return
	 */
	@Query(value ="select * from mydb2schema.requisition r where :requisitionId is null OR r.requisition_id = cast(:requisitionId AS text)",nativeQuery = true) 
	public Iterable<Requisition> findAllByRequisitionId(@Param("requisitionId") String requisitionId);	
	
	/**
	 * This method is used to retrieve the data from the table based on open requisition status.
	 * @param requisition_status
	 * @return
	 */
	@Query("select v from Requisition v where requisition_status=1")	
	public Iterable<Requisition> findAll(String requisition_status);
	
	/**
	 * This method is used to retrieve the data from the table based on close requisition status.
	 * @param requisition_status
	 * @return
	 */
	@Query("select v from Requisition v where requisition_status=2")
	public Iterable<Requisition> findAllByStatus(String requisition_status);
	
	/**
	 * This method is used to display the add new profile page.
	 * @return
	 */
	public Iterable<Requisition> findAllBy();
	
	/**
	 * This method is used to apply the pagination for the  statusopen page.
	 * @param pageable
	 * @param requisition_status
	 * @return
	 */
	@Query("select v from Requisition v where requisition_status=1")
	public Page<Requisition> findAll(Pageable pageable, String requisition_status);
	
	/**
	 * This method is used to apply the pagination for the status close page.
	 * @param pageable
	 * @param requisition_status
	 * @return
	 */
	@Query("select v from Requisition v where requisition_status=2")
	public Page<Requisition> findAllList(Pageable pageable, String requisition_status);
	
	/**
	 * This method is used to retrieve a requisition based on requisitionId
	 * @param requisitionId
	 * @return
	 */
	public Requisition findByRequisitionId(String requisitionId);
	
	/**
	 * This method is used to retrieve a list of all the requisitions 
	 * @return
	 */
	@Query("select v from Requisition v")	
	public Iterable<Requisition> list();	
}