package com.infirmarium.client.components.widgets.navigation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class NavigationButtonWidget extends Composite implements
		HasClickHandlers {

	private final HorizontalPanel backPanel;

	public NavigationButtonWidget() {
		backPanel = new HorizontalPanel();
		backPanel.setStyleName("inf-navigation-button");
		initWidget(backPanel);
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

}
