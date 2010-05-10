package com.infirmarium.client.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.infirmarium.client.components.elements.screens.subscreens.PatientDetailsScreen;
import com.infirmarium.client.core.components.elements.screens.SubScreen;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;
import com.infirmarium.client.core.components.events.SubScreenShownEvent;
import com.infirmarium.client.internationalization.InfirmariumMessages;

public class DepartmentScreen extends TitleScreen {

	private static final String SCREEN_STYLE_NAME = "inf-department-screen";

	private static DepartmentScreenUiBinder uiBinder = GWT
			.create(DepartmentScreenUiBinder.class);

	interface DepartmentScreenUiBinder extends
			UiBinder<Widget, DepartmentScreen> {
	}

	@Inject
	private HandlerManager eventBus;

	@UiField
	Hyperlink killmeLink;
	@UiField
	VerticalPanel content;

	@Inject
	Provider<PatientDetailsScreen> patientDetailsScreenProvider;

	public DepartmentScreen() {
		super(null, SCREEN_STYLE_NAME, null);
	}

	@Inject
	/** @PostConstruct simulation*/
	void construct(InfirmariumMessages infirmariumMessages,
			HandlerManager eventBus) {
		setDescription(infirmariumMessages.departmentsScreenDescription());
		setName(infirmariumMessages.departmentsScreenTitle());
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("killmeLink")
	void handleClick(ClickEvent e) {
		SubScreen referedScreen = patientDetailsScreenProvider.get();
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
