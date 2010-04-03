package com.infirmarium.client.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.infirmarium.client.components.events.handlers.ScreenChangeEventHandler;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;

public class ScreenChangeEvent extends GwtEvent<ScreenChangeEventHandler> {
	public static Type<ScreenChangeEventHandler> TYPE = new Type<ScreenChangeEventHandler>();

	private BaseScreen referedScreen;

	public ScreenChangeEvent(BaseScreen referedScreen) {
		super();
		this.referedScreen = referedScreen;
	}

	public ScreenChangeEvent() {
		super();
	}

	public BaseScreen getReferedScreen() {
		return referedScreen;
	}

	public void setReferedScreen(BaseScreen referedScreen) {
		this.referedScreen = referedScreen;
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
