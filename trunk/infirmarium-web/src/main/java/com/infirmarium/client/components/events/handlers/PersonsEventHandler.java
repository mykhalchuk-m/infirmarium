package com.infirmarium.client.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.components.events.GetPersonsEvent;

public interface PersonsEventHandler extends EventHandler {

	void onGetPersons(GetPersonsEvent event);

}