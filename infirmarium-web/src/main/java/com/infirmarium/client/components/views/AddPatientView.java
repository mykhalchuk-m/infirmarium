package com.infirmarium.client.components.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.presenters.AddPatientPresenter.Display;

public class AddPatientView extends DialogBox implements Display {

	private final Button cancelButton;
	private final Button addButton;
	private final Label messageLabel;
	private final TextBox name;

	public AddPatientView() {
		messageLabel = new Label();
		cancelButton = new Button("Cancel");
		addButton = new Button("Add");
		name = new TextBox();
		setAnimationEnabled(true);

		// We can set the id of a widget by accessing its Element
		cancelButton.getElement().setId("closeButton");
		addButton.getElement().setId("addButton");

		final VerticalPanel dialogVPanel = new VerticalPanel();

		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending request to the server:</b>"));
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(messageLabel);
		dialogVPanel.add(name);
		dialogVPanel.add(addButton);
		dialogVPanel.add(cancelButton);
		setWidget(dialogVPanel);
	}

	@Override
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
	public void setHeader(String header) {
		setText(header);
	}

	@Override
	public HasClickHandlers getAdd() {
		return addButton;
	}

	@Override
	public HasValue<String> getName() {
		return name;
	}

	@Override
	public HasClickHandlers getCancel() {
		return cancelButton;
	}

}
