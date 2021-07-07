package com.sacumen.hiretalent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.sacumen.hiretalent.domain.Requisition;
import com.sacumen.hiretalent.repository.RequisitionRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RequisitionRepositoryTest {
	@Autowired
	private RequisitionRepository requisitionRepository;
	@Test
	void testFindAll() {
		Iterable<Requisition> requisition = (Iterable<Requisition>) requisitionRepository.findAll();
	    assertThat(requisition).size().isGreaterThan(0);
	}
}
