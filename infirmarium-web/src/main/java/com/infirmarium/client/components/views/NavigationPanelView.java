package com.infirmarium.client.components.views;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.presenters.NavigationPanelPresenter.Display;
import com.infirmarium.client.components.widgets.navigation.NavigationButtonWidget;

public class NavigationPanelView extends HorizontalPanel implements Display {

	public NavigationPanelView() {
		RootPanel.get("main-menu-slot").add(this);
	}

	@Override
	public void addNavigationWidget(ClickHandler clickHandler,
			String imageStyleName) {
		NavigationButtonWidget buttonWidget = new NavigationButtonWidget();
		buttonWidget.addClickHandler(clickHandler);
		add(buttonWidget);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void startProcessing() {
	}

	@Override
	public void stopProcessing() {
	}

}
