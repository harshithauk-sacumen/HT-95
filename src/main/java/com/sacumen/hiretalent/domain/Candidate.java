package com.sacumen.hiretalent.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.sacumen.hiretalent.requisitiontype.LevelNumber;
import com.sacumen.hiretalent.requisitiontype.StatusNumber;
import com.sacumen.hiretalent.requisitiontype.StatusNumberAttributeConverter;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * This class is to create the table Candidate in the database.
 *
 */
@Entity
@Table(schema="mydb2schema")
@Getter
@Setter
public class Candidate {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="candidate_id")
	@GenericGenerator(name="candidate_id", strategy="com.sacumen.hiretalent.domain.StringPrefixedSequenceIdGenerator",
	parameters= {
			@Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value="1"),
			@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="C-"),
			@Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%03d")})

	@Id
	@Column(length = 5)
	private String candidateId;  
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "requisition_id")
	private Requisition requisition;  
	@Column(length = 50)
	private String candidateDesignation;  
	@Column(length = 50)
	private String currentCompany;  
	@Column
	private String relevantExperience;	  
	@Column
	private String noticePeriod;	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date sourceDate ;	  
	@Column(length = 20)
	private String recruiterEmail;	  
	@Column(length = 20)
	private String sourceType ;
	@Column(length = 20)
	private String referredBy;	  
	@Column
	@Convert(converter = StatusNumberAttributeConverter.class)
	private StatusNumber statusNumber;	  
	@Column
	private LevelNumber levelNumber;  
	@Column(length = 50)
	private String candidateName;	  
	@Column(nullable = true)
	private Date offeredDate;	  
	@Column(nullable = true)
	private Date offerAcceptedDate;	  
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public Requisition getRequisition() {
		return requisition;
	}
	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}
	public String getCandidateDesignation() {
		return candidateDesignation;
	}
	public void setCandidateDesignation(String candidateDesignation) {
		this.candidateDesignation = candidateDesignation;
	}
	public String getCurrentCompany() {
		return currentCompany;
	}
	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}
	public String getRelevantExperience() {
		return relevantExperience;
	}
	public void setRelevantExperience(String relevantExperience) {
		this.relevantExperience = relevantExperience;
	}
	public String getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public Date getSourceDate() {
		return sourceDate;
	}
	public void setSourceDate(Date sourceDate) {
		this.sourceDate = sourceDate;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getReferredBy() {
		return referredBy;
	}
	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}
	public StatusNumber getStatusNumber() {
		return statusNumber;
	}
	public void setStatusNumber(StatusNumber statusNumber) {
		this.statusNumber = statusNumber;
	}
	public LevelNumber getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(LevelNumber levelNumber) {
		this.levelNumber = levelNumber;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public Date getOfferedDate() {
		return offeredDate;
	}
	public void setOfferedDate(Date offeredDate) {
		this.offeredDate = offeredDate;
	}
	public Date getOfferAcceptedDate() {
		return offerAcceptedDate;
	}
	public void setOfferAcceptedDate(Date offerAcceptedDate) {
		this.offerAcceptedDate = offerAcceptedDate;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCandidatePhoneNumber() {
		return candidatePhoneNumber;
	}
	public void setCandidatePhoneNumber(String candidatePhoneNumber) {
		this.candidatePhoneNumber = candidatePhoneNumber;
	}
	public String getSourcedBy() {
		return sourcedBy;
	}
	public void setSourcedBy(String sourcedBy) {
		this.sourcedBy = sourcedBy;
	}
	public String getProfileCreator() {
		return profileCreator;
	}
	public void setProfileCreator(String profileCreator) {
		this.profileCreator = profileCreator;
	}
	public String getCandidateStatus() {
		return candidateStatus;
	}
	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	@Column(nullable = true)
	private Date joiningDate;	  
	@Column(nullable = true)
	private Date joinedDate;
	@Column
	private String candidateEmail;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date createdDate=new Date(System.currentTimeMillis());
	@Column
	private String candidatePhoneNumber;
	@Column
	private String sourcedBy;
	@Column
	private String profileCreator;
	@Column
	private String candidateStatus;
	private String docName;
	private String docType;	
	@Lob
	private byte[] data;
}