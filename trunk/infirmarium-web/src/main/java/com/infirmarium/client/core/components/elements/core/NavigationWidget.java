package com.infirmarium.client.core.components.elements.core;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;

public class NavigationWidget extends HorizontalPanel {

	public NavigationWidget() {
	}

	public void addScreen(TitleScreen screen) {
		NavigationButtonWidget navigationButton = new NavigationButtonWidget(
				screen);
		add(navigationButton);
	}

}
