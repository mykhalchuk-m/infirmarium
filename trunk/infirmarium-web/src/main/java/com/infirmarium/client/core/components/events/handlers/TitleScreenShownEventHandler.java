package com.infirmarium.client.core.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.core.components.events.TitleScreenShownEvent;

public interface TitleScreenShownEventHandler extends EventHandler {

	void onTitleScreenShownChange(TitleScreenShownEvent event);

}