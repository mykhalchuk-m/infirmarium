package com.infirmarium.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.infirmarium.client.components.elements.RootWidget;
import com.infirmarium.client.gin.InfirmariumGinjector;

/**
 * The entry point for the app.
 */
public class ClientMain implements EntryPoint {

	private RootWidget rootWidget;

	private InfirmariumGinjector injector;

	public void onModuleLoad() {
		injector = GWT.create(InfirmariumGinjector.class);

		rootWidget = injector.getRootWidget();
		RootPanel.get().add(rootWidget);
	}
}
