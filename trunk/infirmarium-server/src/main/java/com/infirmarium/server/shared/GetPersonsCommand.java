package com.infirmarium.server.shared;

import java.io.Serializable;

import net.customware.gwt.dispatch.shared.Action;

import com.infirmarium.server.shared.results.GetPersonsCommandResult;

public class GetPersonsCommand implements Action<GetPersonsCommandResult> ,Serializable{

	private static final long serialVersionUID = 1L;

	private long page;

	public GetPersonsCommand() {
		super();
	}

	public GetPersonsCommand(long page) {
		super();
		this.page = page;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

}