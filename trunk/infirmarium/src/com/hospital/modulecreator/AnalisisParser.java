package com.hospital.modulecreator;

import java.util.ArrayList;
import java.util.List;
import com.hospital.hr.SexTypes;

public class AnalisisParser {
	private SexTypes sex;
	private Record record;

	public AnalisisParser(SexTypes sex, Record record) {
		this.sex = sex;
		this.record = record;
	}

	public double minNorm() {
		String minNorm = "";

		if (getRecordType().equals(FieldTypes.NORM_SEX)) {
			if (sex.equals(SexTypes.MALE)) {
				minNorm = getRecordValues().get(0);
			} else {
				minNorm = getRecordValues().get(2);
			}

		} else if (getRecordType().equals(FieldTypes.NORM)) {
			minNorm = getRecordValues().get(0);
		}
		return Double.valueOf(minNorm);
	}

	public double maxNorm() {
		String maxNorm = "";

		if (getRecordType().equals(FieldTypes.NORM_SEX)) {
			if (sex.equals(SexTypes.MALE)) {
				maxNorm = getRecordValues().get(1);
			} else {
				maxNorm = getRecordValues().get(3);
			}

		} else if (getRecordType().equals(FieldTypes.NORM)) {
			maxNorm = getRecordValues().get(1);
		}
		return Double.valueOf(maxNorm);
	}

	private FieldTypes getRecordType() {
		return record.getField().getType();
	}

	private List<String> getRecordValues() {
		List<String> values = new ArrayList<String>(record.getField()
				.getValues());

		return values;
	}

}
