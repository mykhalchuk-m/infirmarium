package com.infirmarium.client.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.components.events.ScreenChangeEvent;

public interface ScreenChangeEventHandler extends EventHandler {

	void onScreenChange(ScreenChangeEvent event);

}