package com.sacumen.hiretalent.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * This class is to create the table Designation in the database.
 *
 */
@Entity
@Table(schema="mydb2schema")
@Getter
@Setter
@ToString
public class Designation {
	
	@Id
	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}	
}