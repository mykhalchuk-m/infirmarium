package com.infirmarium.client.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;

public class DepartmentScreen extends BaseScreen {

	private static DepartmentScreenUiBinder uiBinder = GWT
			.create(DepartmentScreenUiBinder.class);

	interface DepartmentScreenUiBinder extends
			UiBinder<Widget, DepartmentScreen> {
	}

	@UiField
	public Label header;

	public DepartmentScreen() {
		super("inf-department-screen");
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void init() {
		addWidgetToTopSlot(header);
		super.init();
	}

}
