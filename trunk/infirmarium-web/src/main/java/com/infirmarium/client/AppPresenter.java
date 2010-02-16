package com.infirmarium.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import com.infirmarium.client.components.presenters.PatientsTablePresenter;

public class AppPresenter {
	private HasWidgets container;
	private PatientsTablePresenter patientsTablePresenter;

	@Inject
	public AppPresenter(final DispatchAsync dispatcher,
			final PatientsTablePresenter greetingPresenter) {
		this.patientsTablePresenter = greetingPresenter;
	}

	private void showMain() {
		container.clear();
		container.add(patientsTablePresenter.getDisplay().asWidget());
	}

	public void go(final HasWidgets container) {
		this.container = container;
		showMain();
	}
}