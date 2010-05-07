package com.infirmarium.client.components.elements;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.screens.DepartmentScreen;
import com.infirmarium.client.components.elements.screens.PatientScreen;
import com.infirmarium.client.core.components.elements.core.NavigationWidget;
import com.infirmarium.client.core.components.elements.core.ScreenManagerWidget;
import com.infirmarium.client.gin.GinManager;

public class RootWidget extends Composite {

	private static RootWidgetUiBinder uiBinder = GWT
			.create(RootWidgetUiBinder.class);

	interface RootWidgetUiBinder extends UiBinder<Widget, RootWidget> {
	}

	@UiField
	public NavigationWidget navigationWidget;
	@UiField
	public ScreenManagerWidget screenPanel;

	public RootWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		DepartmentScreen departmentScreen = new DepartmentScreen();
		GinManager.get().injectMembers(departmentScreen);
		navigationWidget.addScreen(departmentScreen);

		PatientScreen patientScreen = new PatientScreen();
		GinManager.get().injectMembers(patientScreen);
		navigationWidget.addScreen(patientScreen);
	}

}
