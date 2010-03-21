package com.infirmarium.server.commandhandlers;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.commons.logging.Log;

import com.google.inject.Inject;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.services.IPersonService;
import com.infirmarium.server.shared.AddPersonCommand;
import com.infirmarium.server.shared.results.AddPersonCommandResult;

public class AddPersonHandler implements
		ActionHandler<AddPersonCommand, AddPersonCommandResult> {
	// TODO there are better way to do logging?
	private final Log logger;
	private final IPersonService personService;

	@Inject
	public AddPersonHandler(IPersonService personService, Log logger) {
		this.logger = logger;
		this.personService = personService;
	}

	@Override
	public AddPersonCommandResult execute(final AddPersonCommand action,
			final ExecutionContext context) throws ActionException {
		AddPersonCommandResult result = new AddPersonCommandResult();
		Person person = new Person();
		person.setFirstName(action.getPerson());
		Database.resultList.add(person);
		return result;

	}

	@Override
	public void rollback(final AddPersonCommand action,
			final AddPersonCommandResult result, final ExecutionContext context)
			throws ActionException {
		// Nothing to do here
	}

	@Override
	public Class<AddPersonCommand> getActionType() {
		return AddPersonCommand.class;
	}
}