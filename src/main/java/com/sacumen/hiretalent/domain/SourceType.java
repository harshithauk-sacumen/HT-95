package com.sacumen.hiretalent.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is to create the table SourceType in the database.
 *
 */
@Entity
@Table(schema="mydb2schema")
@Getter
@Setter
public class SourceType {

	@Id
	private String sourceType ;

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
}
