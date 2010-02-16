package com.infirmarium.shared;

import net.customware.gwt.dispatch.shared.Action;

import com.infirmarium.shared.results.GetPersonsCommandResult;

public class GetPersonsCommand implements Action<GetPersonsCommandResult> {

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