package com.infirmarium.client.components.events;

import com.infirmarium.client.components.events.handlers.PersonsEventHandler;
import com.infirmarium.client.core.components.events.AbstractCommandResultInvokedEvent;
import com.infirmarium.shared.results.GetPersonsCommandResult;

public class GetPersonsEvent
		extends
		AbstractCommandResultInvokedEvent<GetPersonsCommandResult, PersonsEventHandler> {
	public static Type<PersonsEventHandler> TYPE = new Type<PersonsEventHandler>();

	public GetPersonsEvent(GetPersonsCommandResult commandResult) {
		super(commandResult);
	}

	@Override
	public Type<PersonsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final PersonsEventHandler handler) {
		handler.onGetPersons(this);
	}
}