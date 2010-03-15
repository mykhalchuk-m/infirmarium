package com.infirmarium.client.components.events;

import com.infirmarium.client.components.events.handlers.PersonDetailsEventHandler;
import com.infirmarium.client.core.components.events.AbstractCommandResultInvokedEvent;
import com.infirmarium.server.shared.results.GetPersonDetailsCommandResult;

public class GetPersonDetailsEvent
		extends
		AbstractCommandResultInvokedEvent<GetPersonDetailsCommandResult, PersonDetailsEventHandler> {
	public static Type<PersonDetailsEventHandler> TYPE = new Type<PersonDetailsEventHandler>();

	public GetPersonDetailsEvent(GetPersonDetailsCommandResult result) {
		super(result);
	}

	public GetPersonDetailsEvent() {
		super(new GetPersonDetailsCommandResult());
	}
	@Override
	protected void dispatch(final PersonDetailsEventHandler handler) {
		handler.onGetPersonDetails(this);
	}

	@Override
	public Type<PersonDetailsEventHandler> getAssociatedType() {
		return TYPE;
	}

}
