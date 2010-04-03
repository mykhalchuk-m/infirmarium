package com.infirmarium.client.core.components.elements.screens;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.interfaces.InitiableWidget;

public abstract class BaseScreen extends Composite implements InitiableWidget {
	private String navigationStyleName;

	private boolean initialized = false;
	// this field is public because of uibinder
	@UiField
	public AbstractScreenLayout screen;

	public BaseScreen(String navigationStyleName) {
		this.navigationStyleName = navigationStyleName;

	}

	public void addWidgetToTopSlot(Widget widget) {
		screen.topSlot.add(widget);
	}

	public void addWidgetToContentSlot(Widget widget) {
		screen.contentSlot.add(widget);
	}

	@Override
	public void init() {
		screen.icon.setIcon(navigationStyleName);
		setInitialized(true);
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public String getNavigationIconName() {
		return navigationStyleName;
	}
}
