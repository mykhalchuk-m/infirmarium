package com.infirmarium.client.components.events.handlers;

import com.google.gwt.event.shared.EventHandler;
import com.infirmarium.client.components.events.RefreshDataEvent;

public interface RefreshDataEventHandler extends EventHandler{
	public void refreshData(RefreshDataEvent event);
}
