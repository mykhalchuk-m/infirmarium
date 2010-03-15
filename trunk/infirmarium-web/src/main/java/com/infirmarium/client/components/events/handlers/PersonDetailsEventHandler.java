package com.infirmarium.client.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.components.events.GetPersonDetailsEvent;

public interface PersonDetailsEventHandler extends EventHandler {
	void onGetPersonDetails(GetPersonDetailsEvent event);
}
