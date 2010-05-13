package com.infirmarium.client.core.components.elements.core;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;

public class NavigationWidget extends HorizontalPanel {

	@Inject
	private Provider<NavigationButtonWidget> navigationButtonProvider;

	public void addScreen(TitleScreen screen) {
		NavigationButtonWidget navigationButton = navigationButtonProvider
				.get();
		navigationButton.setReferedScreenAndInitIcon(screen);
		add(navigationButton);
	}
}
