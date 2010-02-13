package com.infirmarium.shared.results;

import java.util.List;

import lombok.Data;
import net.customware.gwt.dispatch.shared.Result;

import com.infirmarium.core.persistance.domain.Person;

@Data
public class GetPersonsCommandResult implements Result {

	private static final long serialVersionUID = 1L;

	private List<Person> person;
	private int pageNumber;
	private int totalPages;

}