package com.infirmarium.client.core.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.infirmarium.client.core.components.elements.screens.SubScreen;
import com.infirmarium.client.core.components.events.handlers.SubScreenShownEventHandler;

public class SubScreenShownEvent extends GwtEvent<SubScreenShownEventHandler> {
	public static Type<SubScreenShownEventHandler> TYPE = new Type<SubScreenShownEventHandler>();

	private SubScreen referedScreen;

	public SubScreenShownEvent(SubScreen referedScreen) {
		super();
		this.referedScreen = referedScreen;
	}

	public SubScreenShownEvent() {
		super();
	}

	public SubScreen getReferedScreen() {
		return referedScreen;
	}

	public void setReferedScreen(SubScreen referedScreen) {
		this.referedScreen = referedScreen;
	}

	@Override
	public Type<SubScreenShownEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final SubScreenShownEventHandler handler) {
		handler.onSubScreenShown(this);
	}

}
