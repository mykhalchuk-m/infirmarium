package com.infirmarium.client.components.elements;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.model.records.PersonRecord;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class PatientBrowserWidget extends Composite {

	private static PatientBrowserWidgetUiBinder uiBinder = GWT
			.create(PatientBrowserWidgetUiBinder.class);

	interface PatientBrowserWidgetUiBinder extends
			UiBinder<Widget, PatientBrowserWidget> {
	}

	@UiField
	private Button button;
	@UiField
	private DialogBox dialogBox;

	private  EventBus eventBus;

	private  DispatchAsync dispatcher;

	public PatientBrowserWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		eventBus=null;
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void show() {
		dialogBox.show();
	}

}
