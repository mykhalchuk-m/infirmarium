package com.infirmarium.client.components.elements;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.infirmarium.client.components.elements.screens.DepartmentScreen;
import com.infirmarium.client.components.elements.screens.PatientScreen;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;

public class NavigationWidget extends HorizontalPanel {

	public NavigationWidget() {
		// TODO move elsewhere
		addScreen(new DepartmentScreen());
		addScreen(new PatientScreen());
	}

	private void addScreen(TitleScreen screen) {
		NavigationButtonWidget navigationButton = new NavigationButtonWidget(
				screen);
		add(navigationButton);
	}

}
