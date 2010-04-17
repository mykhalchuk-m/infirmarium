package com.infirmarium.client.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.infirmarium.client.components.model.records.PersonRecord;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;
import com.infirmarium.client.gin.GinManager;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class PatientScreen extends BaseScreen {

	private static final String SCREEN_STYLE_NAME = "inf-patient-screen";

	private static PatientScreenUiBinder uiBinder = GWT
			.create(PatientScreenUiBinder.class);

	interface PatientScreenUiBinder extends UiBinder<Widget, PatientScreen> {
	}

	private static final String DESCRIPTION = GinManager.get()
			.InfirmariumMessages().patientsScreenDescription();

	private static final String TITLE = GinManager.get().InfirmariumMessages()
			.patientsScreenTitle();

	@UiField
	public VerticalPanel content;

	private ListGrid list;

	@Inject
	public PatientScreen() {
		super(SCREEN_STYLE_NAME, TITLE, DESCRIPTION);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void init() {
		list = new ListGrid();
		list.setWidth(910);
		list.setHeight("50%");
		list.setShowAllRecords(true);

		ListGridField nameField = new ListGridField(
				PersonRecord.Attributes.name);
		ListGridField birthField = new ListGridField(
				PersonRecord.Attributes.birthDay);
		list.setFields(nameField, birthField);

		content.add(list);
		screen.contentSlot.add(content);
		addControlLink("inf-small-icon-add", "add new user", null);
		addControlLink("inf-small-icon-add", "remove all", null);
		addControlLink("inf-small-icon-add", "print", null);
		super.init();
	}

}
