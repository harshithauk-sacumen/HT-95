package com.sacumen.hiretalent.requisitiontype;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusNumberAttributeConverter implements AttributeConverter<StatusNumber, Integer> {

	@Override
	public Integer convertToDatabaseColumn(StatusNumber attribute) {
		if (attribute == null)
			return null;
		switch (attribute) {
		case 	Open:
			return 1;
		case Interview:
			return 2;          
		case Passed:
			return 3;
		case Rejected:
			return 4; 
		default:
			throw new IllegalArgumentException(attribute + " not supported.");
		}
	}

	@Override
	public StatusNumber convertToEntityAttribute(Integer dbData) {
		if (dbData == null)
			return null;
		switch (dbData) {
		case 1:
			return StatusNumber.Open;
		case 2:
			return StatusNumber.Interview;            
		case 3:
			return StatusNumber.Passed; 
		case 4:
			return StatusNumber.Rejected;
		default:
			throw new IllegalArgumentException(dbData + " not supported.");
		}
	}
}