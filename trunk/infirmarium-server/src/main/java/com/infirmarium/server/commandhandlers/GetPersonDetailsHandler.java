package com.infirmarium.server.commandhandlers;

import java.util.Date;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.commons.logging.Log;

import com.google.inject.Inject;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.services.IPersonService;
import com.infirmarium.server.shared.GetPersonDetailsCommand;
import com.infirmarium.server.shared.results.GetPersonDetailsCommandResult;

public class GetPersonDetailsHandler implements
		ActionHandler<GetPersonDetailsCommand, GetPersonDetailsCommandResult> {
	// TODO there are better way to do logging?
	private final Log logger;

	@Inject
	public GetPersonDetailsHandler(IPersonService personService, Log logger) {
		this.logger = logger;
	}

	@Override
	public GetPersonDetailsCommandResult execute(
			final GetPersonDetailsCommand action, final ExecutionContext context)
			throws ActionException {
		GetPersonDetailsCommandResult result = new GetPersonDetailsCommandResult();

		logger.info("id " + action.getId() + " was requested");
		Person person1 = new Person();
		person1.setFirstName("Vasia");
		person1.setLastName("Pupkin");
		person1.setBirthday(new Date());

		result.setMessage(person1.toString());
		result.setName(person1.getFirstName() + " " + person1.getLastName());
		return result;

	}

	@Override
	public Class<GetPersonDetailsCommand> getActionType() {
		return GetPersonDetailsCommand.class;
	}

	@Override
	public void rollback(GetPersonDetailsCommand arg0,
			GetPersonDetailsCommandResult arg1, ExecutionContext arg2)
			throws ActionException {

	}

}