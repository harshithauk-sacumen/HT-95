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

import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.repository.RequisitionRepository;
import com.sacumen.hiretalent.service.RequisitionServiceImpl;

import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class RequisitionServiceImplTest {
	@MockBean
	private RequisitionRepository requisitionRepository;
	@InjectMocks
	private RequisitionServiceImpl requisitionServiceImpl;
	
	@Test
	void testFindAll() {
	List<Requisition> requisition = new ArrayList<Requisition>();
	Mockito.when(requisitionRepository.findAll()).thenReturn(requisition);
	//assertThat(requisitionServiceImpl.findAll()).isEqualTo(requisition);
	}
}
