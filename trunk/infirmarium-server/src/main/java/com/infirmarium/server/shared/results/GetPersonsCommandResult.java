package com.infirmarium.server.shared.results;

import java.util.List;

import net.customware.gwt.dispatch.shared.Result;

import com.infirmarium.core.persistance.domain.Person;

public class GetPersonsCommandResult implements Result {

	private static final long serialVersionUID = 1L;

	private List<Person> person;
	private int pageNumber;
	private int totalPages;

	public GetPersonsCommandResult(List<Person> person, int pageNumber,
			int totalPages) {
		super();
		this.person = person;
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
	}

	public GetPersonsCommandResult() {
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}