package com.infirmarium.client.components.events;

import com.google.gwt.event.shared.GwtEvent;
import com.infirmarium.client.components.events.handlers.TitleScreenShownEventHandler;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;

public class TitleScreenShownEvent extends GwtEvent<TitleScreenShownEventHandler> {
	public static Type<TitleScreenShownEventHandler> TYPE = new Type<TitleScreenShownEventHandler>();

	private BaseScreen referedScreen;

	public TitleScreenShownEvent(BaseScreen referedScreen) {
		super();
		this.referedScreen = referedScreen;
	}

	public TitleScreenShownEvent() {
		super();
	}

	public BaseScreen getReferedScreen() {
		return referedScreen;
	}

	public void setReferedScreen(BaseScreen referedScreen) {
		this.referedScreen = referedScreen;
	}

	@Override
	public Type<TitleScreenShownEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(final TitleScreenShownEventHandler handler) {
		handler.onTitleScreenShownChange(this);
	}

}
