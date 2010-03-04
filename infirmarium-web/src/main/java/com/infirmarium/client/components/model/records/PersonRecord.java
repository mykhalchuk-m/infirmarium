package com.infirmarium.client.components.model.records;

import com.infirmarium.core.persistance.domain.Person;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PersonRecord extends ListGridRecord {

	private Person person;

	public PersonRecord(Person person) {
		this.person = person;
		setAttribute(Attributes.name, person.getLastName() + " "
				+ person.getFirstName() + " " + person.getMiddleName());
		setAttribute(Attributes.birthDay, person.getBirthday());
	}

	public static class Attributes {
		public static String name = "name";
		public static String birthDay = "birthDay";
	}

	public Person getPerson() {
		return person;
	}

}
