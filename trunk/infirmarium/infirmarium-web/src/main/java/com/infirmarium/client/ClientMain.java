package com.infirmarium.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * The entry point for the app.
 */
public class ClientMain implements EntryPoint {

	private SimplePanel main;

	public void onModuleLoad() {

		// get better exception handling
		setUncaughtExceptionHandler();

		// Ha ha, who needs Spring! Seriously, integrating it on the GWT client
		// side
		// is more trouble than it's worth!
		//
		// Bootstrap our dependencies (every client gets their own instance)

		main = new SimplePanel();
		main.setSize("100%", "100%");
		main.setWidget(new Button("Hi!"));
		main.setStyleName("back");

		RootPanel.get().add(main);
	}

	/**
	 * better exception handling
	 */
	private void setUncaughtExceptionHandler() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				if (e.getCause() != null
						&& e.getCause() instanceof StatusCodeException) {
					GWT.log("Exception (server-side) :(", e);
					Window.alert("Exception (server-side)");
				} else {
					GWT.log("Exception :(", e);
					Window.alert("Exception " + e.getMessage());
				}
			}
		});
	}

}
