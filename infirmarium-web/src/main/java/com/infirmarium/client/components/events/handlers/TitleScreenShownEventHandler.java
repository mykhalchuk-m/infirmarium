package com.infirmarium.client.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.components.events.TitleScreenShownEvent;

public interface TitleScreenShownEventHandler extends EventHandler {

	void onTitleScreenShownChange(TitleScreenShownEvent event);

}