package com.infirmarium.client.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.infirmarium.client.components.events.handlers.ScreenChangeEventHandler;

public class ScreenChangeEvent extends GwtEvent<ScreenChangeEventHandler> {
	public static Type<ScreenChangeEventHandler> TYPE = new Type<ScreenChangeEventHandler>();
	private Class newScreenClass;

	public ScreenChangeEvent() {
		super();
	}

	public Class getNewScreenClass() {
		return newScreenClass;
	}

	public void setNewScreenClass(
			Class newScreenClass) {
		this.newScreenClass = newScreenClass;
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
