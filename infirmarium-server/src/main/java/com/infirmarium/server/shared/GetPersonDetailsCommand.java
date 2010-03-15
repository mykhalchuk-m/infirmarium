package com.infirmarium.server.shared;

import java.io.Serializable;

import net.customware.gwt.dispatch.shared.Action;

import com.infirmarium.server.shared.results.GetPersonDetailsCommandResult;

public class GetPersonDetailsCommand implements
		Action<GetPersonDetailsCommandResult>, Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	public GetPersonDetailsCommand(Integer id) {
		super();
		this.id = id;
	}
	public GetPersonDetailsCommand() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}