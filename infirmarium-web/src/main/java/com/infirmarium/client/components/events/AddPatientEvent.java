package com.infirmarium.client.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.infirmarium.client.components.events.handlers.AddPatientEventHandler;

public class AddPatientEvent extends GwtEvent<AddPatientEventHandler>{
	public static Type<AddPatientEventHandler> TYPE = new Type<AddPatientEventHandler>();
	public AddPatientEvent() {
	}

	@Override
	protected void dispatch(AddPatientEventHandler handler) {
		handler.openAddPersonPresenter(this);
	}

	@Override
	public Type<AddPatientEventHandler> getAssociatedType() {
		return TYPE;
	}
}