package com.infirmarium.client.components.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.presenters.PatientDetailsPresenter.Display;

public class PatientDetailsView extends DialogBox implements Display {

	private final Button closeButton;
	private final Label messageLabel;

	public PatientDetailsView() {
		messageLabel = new Label();
		closeButton = new Button("Close");

		setAnimationEnabled(true);

		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");

		final VerticalPanel dialogVPanel = new VerticalPanel();

		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending request to the server:</b>"));
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(messageLabel);
		dialogVPanel.add(closeButton);
		setWidget(dialogVPanel);
	}

	@Override
	public HasClickHandlers getClose() {
		return closeButton;
	}

	@Override
	public DialogBox getDialogBox() {
		return this;
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
	public void setData(String data) {
		messageLabel.setText(data);
	}

	@Override
	public void setHeader(String header) {
		setText(header);
	}

}
