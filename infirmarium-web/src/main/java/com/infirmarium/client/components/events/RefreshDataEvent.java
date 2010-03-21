package com.infirmarium.client.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.infirmarium.client.components.events.handlers.RefreshDataEventHandler;

public class RefreshDataEvent extends GwtEvent<RefreshDataEventHandler> {
	public static Type<RefreshDataEventHandler> TYPE = new Type<RefreshDataEventHandler>();
	public RefreshDataEvent() {
	}

	@Override
	protected void dispatch(RefreshDataEventHandler handler) {
		handler.refreshData(this);
	}

	@Override
	public Type<RefreshDataEventHandler> getAssociatedType() {
		return TYPE;
	}
}
