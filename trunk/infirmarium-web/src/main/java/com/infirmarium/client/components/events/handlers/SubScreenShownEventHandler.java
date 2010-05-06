package com.infirmarium.client.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.components.events.SubScreenShownEvent;

public interface SubScreenShownEventHandler extends EventHandler {

	void onSubScreenShown(SubScreenShownEvent event);

}