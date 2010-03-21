package com.infirmarium.server.shared;

import java.io.Serializable;

import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.server.shared.results.AddPersonCommandResult;

import net.customware.gwt.dispatch.shared.Action;

public class AddPersonCommand implements Action<AddPersonCommandResult>,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String person;

	public AddPersonCommand(String person) {
		super();
		this.setPerson(person);
	}

	public AddPersonCommand() {
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPerson() {
		return person;
	}

}
