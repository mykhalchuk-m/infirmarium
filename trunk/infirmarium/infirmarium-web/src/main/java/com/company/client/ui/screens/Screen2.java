package com.company.client.ui.screens;

import com.company.client.ClientState;
import com.company.client.ServiceRegistry;
import com.company.client.ui.common.ProgressBarPopup;
import com.company.client.ui.widget.Pane;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


public class Screen2 extends Pane {

	private ListBox listBox;
	private ProgressBarPopup progressBarPopup;

	public Screen2(ClientState clientState, ServiceRegistry serviceRegistry) {
        super(clientState, serviceRegistry);

		//containing panel
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
		horizontalPanel.setWidth("25%");

		// buttons
		VerticalPanel buttonsPanel = new VerticalPanel();
		buttonsPanel.setSpacing(18);
		Button longRunningOperationButton = new Button("Long running operation...");

		buttonsPanel.add(longRunningOperationButton);

		horizontalPanel.add(buttonsPanel);

		
		//button listeners

		longRunningOperationButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				callLongRunningService(15000);
			}
		});
		
		initWidget(horizontalPanel);
	}
	
	void callLongRunningService(int runningTime) {
        progressBarPopup = new ProgressBarPopup();
        progressBarPopup.setText("Running for " + runningTime + " millis...");
		getServiceRegistry().getTestService().longRunningMethod(runningTime, new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				progressBarPopup.hide();
				Window.alert("RPC failed.");
			}
			public void onSuccess(String result) {
				progressBarPopup.hide();
				Window.alert("Recieved " + result);
			}
		});
	}
	

}
