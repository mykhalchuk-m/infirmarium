package com.infirmarium.client.components.elements.screens.subscreens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.infirmarium.client.core.components.elements.screens.SubScreen;
import com.infirmarium.client.core.components.events.SubScreenShownEvent;

public class PatientDetailsScreen extends SubScreen {

	private static PatientDetailsScreenUiBinder uiBinder = GWT
			.create(PatientDetailsScreenUiBinder.class);

	interface PatientDetailsScreenUiBinder extends
			UiBinder<Widget, PatientDetailsScreen> {
	}

	private static final String TITLE = "details";

	@UiField
	public HTMLPanel content;
	@UiField
	public Hyperlink killmeLink;

	@Inject
	public PatientDetailsScreen() {
		super(TITLE);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void init() {
		getLayout().contentSlot.add(content);
		super.init();
	}

	@UiHandler("killmeLink")
	void handleClick(ClickEvent e) {
		SubScreen referedScreen = new PatientDetailsScreen();
		referedScreen.setName("another sub level");
		eventBus.fireEvent(new SubScreenShownEvent(referedScreen));
	}

}
