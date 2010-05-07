package com.infirmarium.client.components.elements.screens;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.infirmarium.client.components.elements.screens.subscreens.PatientDetailsScreen;
import com.infirmarium.client.core.components.elements.screens.SubScreen;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;
import com.infirmarium.client.core.components.events.SubScreenShownEvent;
import com.infirmarium.client.gin.GinManager;

public class DepartmentScreen extends TitleScreen {

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
	@Inject
	private EventBus eventBus /* = GinManager.get().getEventBus() */;
	@UiField
	public Hyperlink killmeLink;
	@UiField
	public VerticalPanel content;

	public DepartmentScreen() {
		super(TITLE, SCREEN_STYLE_NAME, DESCRIPTION);
		initWidget(uiBinder.createAndBindUi(this));

	}

	@UiHandler("killmeLink")
	void handleClick(ClickEvent e) {
		SubScreen referedScreen = new PatientDetailsScreen();
		eventBus.fireEvent(new SubScreenShownEvent(referedScreen));
	}

	@Override
	public void init() {
		getLayout().contentSlot.add(content);
		addControlLink("inf-small-icon-add", "add new department", null);
		addControlLink("inf-small-icon-add", "remove all", null);
		addControlLink("inf-small-icon-add", "print", null);
		addControlLink("inf-small-icon-add", "send by email", null);
		super.init();
	}

}
