package com.infirmarium.server.commandhandlers;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.commons.logging.Log;

import com.google.inject.Inject;
import com.infirmarium.core.services.IPersonService;
import com.infirmarium.server.shared.GetPersonsCommand;
import com.infirmarium.server.shared.results.GetPersonsCommandResult;

public class GetPersonsHandler implements
		ActionHandler<GetPersonsCommand, GetPersonsCommandResult> {
	// TODO there are better way to do logging?
	private final Log logger;
	private final IPersonService personService;

	@Inject
	public GetPersonsHandler(IPersonService personService, Log logger) {
		this.logger = logger;
		this.personService = personService;
	}

	@Override
	public GetPersonsCommandResult execute(final GetPersonsCommand action,
			final ExecutionContext context) throws ActionException {
		GetPersonsCommandResult result = new GetPersonsCommandResult();
		// TODO add paging

		result.setPerson(Database.resultList);

		return result;

	}

	@Override
	public void rollback(final GetPersonsCommand action,
			final GetPersonsCommandResult result, final ExecutionContext context)
			throws ActionException {
		// Nothing to do here
	}

	@Override
	public Class<GetPersonsCommand> getActionType() {
		return GetPersonsCommand.class;
	}
}