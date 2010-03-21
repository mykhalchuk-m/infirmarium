package com.infirmarium.client.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.components.events.AddPatientEvent;

public interface AddPatientEventHandler extends EventHandler{
	public void openAddPersonPresenter(AddPatientEvent event);
}
