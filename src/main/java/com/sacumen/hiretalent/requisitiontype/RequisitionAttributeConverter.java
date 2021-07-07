package com.sacumen.hiretalent.requisitiontype;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RequisitionAttributeConverter implements AttributeConverter<RequisitionType, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(RequisitionType attribute) {
		if (attribute == null)
			return null;
		switch (attribute) {
		case FullTime:
			return 1;
		case Contractor:
			return 2;
		default:
			throw new IllegalArgumentException(attribute + " not supported.");
		}
	}
	
	@Override
	public RequisitionType convertToEntityAttribute(Integer dbData) {
		if (dbData == null)
			return null;
		switch (dbData) {
		case 1:
			return RequisitionType.FullTime;
		case 2:
			return RequisitionType.Contractor;       
		default:
			throw new IllegalArgumentException(dbData + " not supported.");
		}
	}
}