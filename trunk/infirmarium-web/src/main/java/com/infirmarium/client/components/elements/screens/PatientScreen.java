package com.infirmarium.client.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.infirmarium.client.components.elements.interfaces.InitiableWidget;
import com.infirmarium.client.components.model.records.PersonRecord;
import com.infirmarium.client.core.components.elements.screens.AbstractScreen;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class PatientScreen extends Composite implements InitiableWidget {

	private static final String SCREEN_NAME = "patients";
	private static PatientScreenUiBinder uiBinder = GWT
			.create(PatientScreenUiBinder.class);

	interface PatientScreenUiBinder extends UiBinder<Widget, PatientScreen> {
	}

	@UiField
	public HTMLPanel header;

	@UiField
	public VerticalPanel content;

	@UiField
	public AbstractScreen screen;

	private ListGrid list;
	private boolean initialized = false;

	@Inject
	public PatientScreen() {
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
		screen.topSlot.add(header);
		screen.contentSlot.add(content);
		initialized = true;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

}
