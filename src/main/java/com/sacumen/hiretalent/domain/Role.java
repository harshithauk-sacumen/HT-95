package com.sacumen.hiretalent.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is to create the table Role in the database.
 *
 */
@Entity
@Table(schema="mydb2schema")
@Getter
@Setter
public class Role {
	@Id
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}