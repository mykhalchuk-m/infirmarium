package com.infirmarium.server.shared.results;

import net.customware.gwt.dispatch.shared.Result;

public class GetPersonDetailsCommandResult implements Result {

	private static final long serialVersionUID = 1L;

	private String name;
	private String message;

	public GetPersonDetailsCommandResult(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GetPersonDetailsCommandResult() {
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

}