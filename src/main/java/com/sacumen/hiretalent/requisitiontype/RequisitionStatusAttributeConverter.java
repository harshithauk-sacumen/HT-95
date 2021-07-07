package com.sacumen.hiretalent.requisitiontype;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RequisitionStatusAttributeConverter implements AttributeConverter<RequisitionStatus, Integer>{

	@Override
	public Integer convertToDatabaseColumn(RequisitionStatus attribute) {
		if (attribute == null)
			return null;

		switch (attribute) {
		case Open:
			return 1;
		case Closed:
			return 2;
		default:
			throw new IllegalArgumentException(attribute + " not supported.");
		}
	}

	@Override
	public RequisitionStatus convertToEntityAttribute(Integer dbData) {
		if (dbData == null)
			return null;
		switch (dbData) {
		case 1:
			return RequisitionStatus.Open;
		case 2:
			return RequisitionStatus.Closed;
		default:
			throw new IllegalArgumentException(dbData + " not supported.");
		}
	}
}