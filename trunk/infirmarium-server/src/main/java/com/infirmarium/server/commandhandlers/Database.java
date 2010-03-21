package com.infirmarium.server.commandhandlers;

import java.util.ArrayList;
import java.util.Date;

import com.infirmarium.core.persistance.domain.Person;

public class Database {
	public static ArrayList<Person> resultList = new ArrayList<Person>();
	static {
		Person person1 = new Person();
		person1.setFirstName("Vasia");
		person1.setLastName("Pupkin");
		person1.setBirthday(new Date());

		Person person2 = new Person();
		person2.setFirstName("Petia");
		person2.setLastName("Sidorov");
		person2.setBirthday(new Date());

		resultList.add(person1);
		resultList.add(person2);
	}
}
