package com.infirmarium.client.components.elements;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.infirmarium.client.components.elements.screens.DepartmentScreen;
import com.infirmarium.client.components.elements.screens.PatientScreen;
import com.infirmarium.client.core.components.elements.core.NavigationWidget;
import com.infirmarium.client.core.components.elements.core.ScreenManagerWidget;

public class RootWidget extends Composite {

	private static RootWidgetUiBinder uiBinder = GWT
			.create(RootWidgetUiBinder.class);

	interface RootWidgetUiBinder extends UiBinder<Widget, RootWidget> {
	}

	@UiField(provided = true)
	public NavigationWidget navigationWidget;
	@UiField(provided = true)
	public ScreenManagerWidget screenPanel;

	@Inject
	void construct(NavigationWidget navigationWidget,
			ScreenManagerWidget screenPanel, DepartmentScreen departmentScreen,
			PatientScreen patientScreen) {
		this.navigationWidget = navigationWidget;
		this.screenPanel = screenPanel;
		initWidget(uiBinder.createAndBindUi(this));
		navigationWidget.addScreen(departmentScreen);
		navigationWidget.addScreen(patientScreen);
	}
}
