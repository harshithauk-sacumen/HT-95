package com.sacumen.hiretalent.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is to create the table Project in the database.
 *
 */
@Entity
@Table(schema="mydb2schema")
@Getter
@Setter
@ToString
public class Project {

	@Id
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}