package com.infirmarium.shared;

import lombok.Data;
import net.customware.gwt.dispatch.shared.Action;

import com.infirmarium.shared.results.GetPersonsCommandResult;

@Data
public class GetPersonsCommand implements Action<GetPersonsCommandResult> {

	private static final long serialVersionUID = 1L;

	private long page;

	public GetPersonsCommand(long page) {
		super();
		this.page = page;
	}

}