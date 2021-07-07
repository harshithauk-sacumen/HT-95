package com.sacumen.hiretalent;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.repository.CandidateRepository;
import com.sacumen.hiretalent.service.CandidateServiceImpl;

import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CandidateServiceImplTest {
	@MockBean
	private CandidateRepository candidateRepository;
	@InjectMocks
	private CandidateServiceImpl candidateServiceImpl;
	
	@Test
	void testFindAll() {
	List<Candidate> candidate = new ArrayList<Candidate>();
	Mockito.when(candidateRepository.findAll()).thenReturn(candidate);
	assertThat(candidateServiceImpl.findAll("R-001")).isEqualTo(candidate);
	}
	@Test
	void testCountByRequisitionId() {
		Long candidate = candidateRepository.countByRequisitionId("R-001");    
		Mockito.when(candidateRepository.countByRequisitionId("R-001")).thenReturn(candidate);
		assertThat(candidateServiceImpl.countByRequisitionId("R-001")).isEqualTo(candidate);
	}
	@Test
	void testCountByL1() {
		Long candidate = candidateRepository.countByL1("R-001");    
		Mockito.when(candidateRepository.countByL1("R-001")).thenReturn(candidate);
		assertThat(candidateServiceImpl.countByL1("R-001")).isEqualTo(candidate);	
		}
	@Test
	void testCountByL2() {
		Long candidate = candidateRepository.countByL2("R-001");    
		Mockito.when(candidateRepository.countByL2("R-001")).thenReturn(candidate);
		assertThat(candidateServiceImpl.countByL2("R-001")).isEqualTo(candidate);	
		}
	@Test
	void testCountByL3() {
		Long candidate = candidateRepository.countByL3("R-001");    
		Mockito.when(candidateRepository.countByL3("R-001")).thenReturn(candidate);
		assertThat(candidateServiceImpl.countByL3("R-001")).isEqualTo(candidate);	
	}
}
