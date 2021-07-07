package com.sacumen.hiretalent.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.sacumen.hiretalent.requisitiontype.RequisitionAttributeConverter;
import com.sacumen.hiretalent.requisitiontype.RequisitionStatus;
import com.sacumen.hiretalent.requisitiontype.RequisitionStatusAttributeConverter;
import com.sacumen.hiretalent.requisitiontype.RequisitionType;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is to create the table Requisition in the database.
 *
 */
@Entity
@Table(schema="mydb2schema")
@Getter
@Setter
public class Requisition {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="req_id")
	@GenericGenerator(name="req_id", strategy="com.sacumen.hiretalent.domain.StringPrefixedSequenceIdGenerator",
	parameters= {
			@Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value="1"),
			@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="R-"),
			@Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%03d")})
	@Id
	@Column(length = 5)
	private String requisitionId; 
	@Column(length = 20)
	private String hiringManager; 
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date createdDate=new Date(System.currentTimeMillis());
	@Column(length = 50)
	private String projectName; 
	@Column(length = 50)
	private String roleDesignation; 
	@Column(length = 5)
	private String experienceRange ;  
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public String getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getRoleDesignation() {
		return roleDesignation;
	}
	public void setRoleDesignation(String roleDesignation) {
		this.roleDesignation = roleDesignation;
	}
	public String getExperienceRange() {
		return experienceRange;
	}
	public void setExperienceRange(String experienceRange) {
		this.experienceRange = experienceRange;
	}
	public String getMustHaveSkill1() {
		return mustHaveSkill1;
	}
	public void setMustHaveSkill1(String mustHaveSkill1) {
		this.mustHaveSkill1 = mustHaveSkill1;
	}
	public String getMustHaveSkill2() {
		return mustHaveSkill2;
	}
	public void setMustHaveSkill2(String mustHaveSkill2) {
		this.mustHaveSkill2 = mustHaveSkill2;
	}
	public String getMustHaveSkill3() {
		return mustHaveSkill3;
	}
	public void setMustHaveSkill3(String mustHaveSkill3) {
		this.mustHaveSkill3 = mustHaveSkill3;
	}
	public String getGoodToHaveSkill1() {
		return goodToHaveSkill1;
	}
	public void setGoodToHaveSkill1(String goodToHaveSkill1) {
		this.goodToHaveSkill1 = goodToHaveSkill1;
	}
	public String getGoodToHaveSkill2() {
		return goodToHaveSkill2;
	}
	public void setGoodToHaveSkill2(String goodToHaveSkill2) {
		this.goodToHaveSkill2 = goodToHaveSkill2;
	}
	public String getGoodToHaveSkill3() {
		return goodToHaveSkill3;
	}
	public void setGoodToHaveSkill3(String goodToHaveSkill3) {
		this.goodToHaveSkill3 = goodToHaveSkill3;
	}
	public RequisitionType getRequisitionType() {
		return requisitionType;
	}
	public void setRequisitionType(RequisitionType requisitionType) {
		this.requisitionType = requisitionType;
	}
	public Set<Candidate> getCandidate() {
		return candidate;
	}
	public void setCandidate(Set<Candidate> candidate) {
		this.candidate = candidate;
	}
	public RequisitionStatus getRequisitionStatus() {
		return requisitionStatus;
	}
	public void setRequisitionStatus(RequisitionStatus requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}
	@Column(length = 20)
	private String mustHaveSkill1 ;  
	@Column(length = 20)
	private String mustHaveSkill2;  
	@Column(length = 20)
	private String mustHaveSkill3 ;  
	@Column(length = 20)
	private String goodToHaveSkill1;  
	@Column(length = 20)
	private String goodToHaveSkill2; 
	@Column(length = 20)
	private String goodToHaveSkill3; 
	@Column(length = 1)	 
	@Convert(converter = RequisitionAttributeConverter.class) 
	private RequisitionType requisitionType;
	@OneToMany(mappedBy = "requisition",cascade = CascadeType.ALL) 
	private Set<Candidate> candidate = new HashSet<>(); 
	@Column 
	@Convert(converter = RequisitionStatusAttributeConverter.class) 
	private RequisitionStatus requisitionStatus=RequisitionStatus.Open;
}
