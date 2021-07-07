package com.sacumen.hiretalent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import java.sql.Date;

import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.repository.CandidateRepository;
import com.sacumen.hiretalent.requisitiontype.LevelNumber;
import com.sacumen.hiretalent.requisitiontype.StatusNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class) 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class CandidateRepositoryTest {
		
	@Autowired
    private CandidateRepository candidateRepository;
	
	@BeforeEach
    public   void setUp() throws Exception {
		Candidate candidate=new Candidate();
		Requisition requisition=new Requisition();
		candidate.setCandidateId("C-017");
		candidate.setCandidateDesignation("Software Engineer");
		candidate.setCandidateName("Ramesh");
		candidate.setCurrentCompany("Google");
		candidate.setJoinedDate(new Date(2021-11-17));
		candidate.setJoiningDate(new Date(2021-11-17));
		candidate.setLevelNumber(LevelNumber.L1);
		candidate.setNoticePeriod("2");
		candidate.setOfferAcceptedDate(new Date(2021-11-11));
		candidate.setOfferedDate(new Date(2021-11-11));
		candidate.setRecruiterEmail("depika@gmail.com");
		candidate.setReferredBy("Ritik");
		candidate.setRelevantExperience("5");
		candidate.setSourceDate(new Date(2021-10-17));
		candidate.setSourceType("LinkedIn");
		candidate.setStatusNumber(StatusNumber.Open);
		candidate.setRequisition(requisition);
		candidateRepository.save(candidate);
	}
	@Test
	void testFindAll() {
		Iterable<Candidate> candidate= (Iterable<Candidate>) candidateRepository.findAll("R-001");
		assertThat(candidate).size().isGreaterThan(0);
	}
	@Test
	void testCountByRequisitionId() {
		Long candidate = candidateRepository.countByRequisitionId("R-001");    
	    assertThat(candidate).isEqualTo(16L);
	}
	@Test
	void testCountByL1() {
		Long candidate = candidateRepository.countByL1("R-001");    
	    assertThat(candidate).isEqualTo(4L);
	}
	@Test
	void testCountByL2() {
		//Long candidate = candidateRepository.countByL2("R-001","2");    
	    //assertThat(candidate).isEqualTo(4L);
	}
	@Test
	void testCountByL3() {
		//Long candidate = candidateRepository.countByL3("R-001","3");    
	    //assertThat(candidate).isEqualTo(4L);
	}
	
}
