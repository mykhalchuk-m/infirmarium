package com.infirmarium.client.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.infirmarium.client.components.events.handlers.ScreenChangeEventHandler;

public class ScreenChangeEvent extends GwtEvent<ScreenChangeEventHandler> {
	public static Type<ScreenChangeEventHandler> TYPE = new Type<ScreenChangeEventHandler>();

	private int screenId;

	public ScreenChangeEvent(int screenId) {
		super();
		this.screenId = screenId;
	}

	public ScreenChangeEvent() {
		super();
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	@Override
	public Type<ScreenChangeEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final ScreenChangeEventHandler handler) {
		handler.onScreenChange(this);
	}

}
