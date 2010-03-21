package com.infirmarium.client.components.views;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.model.records.PersonRecord;
import com.infirmarium.client.components.presenters.PatientsTablePresenter.Display;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class PatientsTableView extends Composite implements Display {

	private final ListGrid list;
	private final Button addPattientButton;

	public PatientsTableView() {
		reset();
		addPattientButton = new Button("Add new Patient");
		list = new ListGrid();
		list.setWidth(910);
		list.setHeight("50%");
		list.setShowAllRecords(true);

		ListGridField nameField = new ListGridField(
				PersonRecord.Attributes.name);
		ListGridField birthField = new ListGridField(
				PersonRecord.Attributes.birthDay);
		list.setFields(nameField, birthField);

		RootPanel.get("page-content-slot").add(list);
		RootPanel.get("page-content-slot").add(addPattientButton);
		list.redraw();
	}

	public void reset() {

	}

	/**
	 * Returns this widget as the {@link WidgetDisplay#asWidget()} value.
	 */
	public Widget asWidget() {

		return this;
	}

	@Override
	public void startProcessing() {
	}

	@Override
	public void stopProcessing() {
	}

	@Override
	public ListGrid getListGrid() {
		return list;
	}

	@Override
	public HasClickHandlers getAddPatient() {
		return addPattientButton;
	}
}