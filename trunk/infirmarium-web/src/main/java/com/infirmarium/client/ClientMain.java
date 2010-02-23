package com.infirmarium.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.infirmarium.client.gin.InfirmariumGinjector;

/**
 * The entry point for the app.
 */
public class ClientMain implements EntryPoint {

	private final InfirmariumGinjector injector = GWT
			.create(InfirmariumGinjector.class);

	public void onModuleLoad() {
		final AppPresenter appPresenter = injector.getAppPresenter();
		appPresenter.go(RootPanel.get());
		injector.getPlaceManager().fireCurrentPlace();
	}

}
