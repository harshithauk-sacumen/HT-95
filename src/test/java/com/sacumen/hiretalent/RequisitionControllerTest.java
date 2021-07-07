package com.sacumen.hiretalent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import com.sacumen.hiretalent.controller.RequisitionController;
import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.repository.CandidateRepository;
import com.sacumen.hiretalent.service.CandidateServiceImpl;
import com.sacumen.hiretalent.service.RequisitionServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.List;


public class RequisitionControllerTest {
	 @InjectMocks
	 private RequisitionController requisitionController;
	 @Mock
	 private RequisitionServiceImpl  requisitionServiceImpl;
	 @Mock
	 private CandidateServiceImpl  candidateServiceImpl;
	 @Mock
	 private CandidateRepository candidateRepository;
	 @Mock
	 View mockView;
	 @Mock
	 MockMvc mockMvc;

	  @BeforeEach
	    public void setUp() throws Exception {
	        mockMvc = MockMvcBuilders.standaloneSetup(requisitionController).setSingleView(mockView)
	                .build();
	    }
	@Test
	public void testIndex() throws Exception{
		
		List<Requisition> requisition = new ArrayList<Requisition>();
		//when(requisitionServiceImpl.findAll(requisitionId)).thenReturn(requisition);
		
		List<Candidate> candidateFindAll = new ArrayList<Candidate>();		
		when(candidateServiceImpl.findAll("R-001")).thenReturn(candidateFindAll);
		
		Long candidateReqId = candidateRepository.countByRequisitionId("R-001");  		
		when(candidateServiceImpl.countByRequisitionId("R-001")).thenReturn(candidateReqId);
		
		Long candidateL1 = candidateRepository.countByL1("R-001");  
		when(candidateServiceImpl.countByL1("R-001")).thenReturn(candidateL1);
		
		
		  Long candidateL2 = candidateRepository.countByL2("R-001");
		  when(candidateServiceImpl.countByL2("R-001")).thenReturn(candidateL2);
		 
		 Long candidateL3 = candidateRepository.countByL3("R-001");
		 when(candidateServiceImpl.countByL3("R-001")).thenReturn(candidateL3);
		 
        mockMvc.perform(get("/requisition"))
                .andExpect(status().isOk())
                .andExpect(view().name("requisition/index"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/WEB-INF/index.jsp"));

       
	}
	@Test
	public void testShowViewRequisition() throws Exception{
		 mockMvc.perform(get("/viewrequisition"))
         .andExpect(status().isOk())
         .andExpect(view().name("requisition/viewrequisition"))
         .andExpect(forwardedUrl("/WEB-INF/jsp/WEB-INF/viewrequisition.jsp"));
	}
	@Test
	public void testShowViewProfiles() throws Exception{
		mockMvc.perform(get("/viewprofiles"))
        .andExpect(status().isOk())
        .andExpect(view().name("requisition/viewprofile"))
        .andExpect(forwardedUrl("/WEB-INF/jsp/WEB-INF/viewprofile.jsp"));
	}
	@Test
	public void testShowAddProfile() throws Exception{
		mockMvc.perform(get("/addprofile"))
        .andExpect(status().isOk())
        .andExpect(view().name("requisition/addprofile"))
        .andExpect(forwardedUrl("/WEB-INF/jsp/WEB-INF/addprofile.jsp"));
	}
}
