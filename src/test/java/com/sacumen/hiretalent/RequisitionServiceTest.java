package com.sacumen.hiretalent;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import com.sacumen.hiretalent.domain.Candidate;
import com.sacumen.hiretalent.domain.Designation;
import com.sacumen.hiretalent.domain.Project;
import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.repository.CandidateRepository;
import com.sacumen.hiretalent.repository.DesignationRepository;
import com.sacumen.hiretalent.repository.ProjectRepository;
import com.sacumen.hiretalent.repository.RequisitionRepository;

@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RequisitionServiceTest {
	//@Autowired
		//RequisitionService reqService;
		
		@Autowired
		DesignationRepository designationRepo;
		
		@Autowired
		ProjectRepository projectRepo;
		
		@Autowired
		RequisitionRepository reqRepo;
		
		@Autowired
		private CandidateRepository candidateRepository;
		
		@Test
		public void findDesignationTest() {
			Iterable<Designation> designations = designationRepo.findAll();
			assertNotNull(designations);
			System.out.println(designations);
		}
		
		@Test
		public void findProjectTest() {
		  Iterable<Project> projectNames = projectRepo.findAll();
			assertNotNull(projectNames);
			System.out.println(projectNames);
		}
		@Test
		public void createTest() {
			Requisition req=new Requisition();
			req.setRoleDesignation("python developer");
			req.setProjectName("Hire Talent");
			req.setExperienceRange("5,7");
			req.setMustHaveSkill1("python");
			req.setMustHaveSkill2("java");
			req.setMustHaveSkill3("docker");
			req.setGoodToHaveSkill1("react");
			req.setGoodToHaveSkill2("html");
			req.setGoodToHaveSkill3("angular");
			//req.setRequisitionType(2);
			Requisition savedReq = reqRepo.save(req);
			assertNotNull(savedReq);
			System.out.println(savedReq);
	}
		
		@Test
		void testFindAll() {
		Iterable<Candidate> requisition=(Iterable<Candidate>) candidateRepository.findAll();
		assertThat(requisition).size().isGreaterThan(0);
		}


}
