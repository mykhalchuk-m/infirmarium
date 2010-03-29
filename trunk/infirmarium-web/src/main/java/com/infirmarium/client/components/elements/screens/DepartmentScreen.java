package com.infirmarium.client.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.interfaces.InitiableWidget;
import com.infirmarium.client.core.components.elements.screens.AbstractScreen;

public class DepartmentScreen extends Composite implements InitiableWidget {

	private static final String SCREEN_NAME = "departments";
	private static DepartmentScreenUiBinder uiBinder = GWT
			.create(DepartmentScreenUiBinder.class);

	interface DepartmentScreenUiBinder extends
			UiBinder<Widget, DepartmentScreen> {
	}

	@UiField
	public Label header;

	@UiField
	public AbstractScreen screen;
	private boolean initialized = false;

	public DepartmentScreen() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void init() {
		screen.topSlot.add(header);
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}
