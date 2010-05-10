package com.infirmarium.client.core.components.elements.core;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.inject.Inject;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;

public class NavigationWidget extends HorizontalPanel {

	@Inject
	private NavigationButtonWidget navigationButton;

	public void addScreen(TitleScreen screen) {
		navigationButton.setReferedScreenAndInitIcon(screen);
		add(navigationButton);
	}
}
