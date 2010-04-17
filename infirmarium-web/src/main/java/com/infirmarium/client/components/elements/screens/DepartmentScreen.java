package com.infirmarium.client.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;
import com.infirmarium.client.gin.GinManager;

public class DepartmentScreen extends BaseScreen {

	private static final String SCREEN_STYLE_NAME = "inf-department-screen";

	private static DepartmentScreenUiBinder uiBinder = GWT
			.create(DepartmentScreenUiBinder.class);

	interface DepartmentScreenUiBinder extends
			UiBinder<Widget, DepartmentScreen> {
	}

	private static final String DESCRIPTION = GinManager.get()
			.InfirmariumMessages().departmentsScreenDescription();

	private static final String TITLE = GinManager.get().InfirmariumMessages()
			.departmentsScreenTitle();

	public DepartmentScreen() {
		super(SCREEN_STYLE_NAME, TITLE, DESCRIPTION);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void init() {
		addControlLink("inf-small-icon-add", "add new department", null);
		addControlLink("inf-small-icon-add", "remove all", null);
		addControlLink("inf-small-icon-add", "print", null);
		addControlLink("inf-small-icon-add", "send by email", null);
		super.init();
	}

}
