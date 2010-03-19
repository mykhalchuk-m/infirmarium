package com.infirmarium.client.components.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import com.infirmarium.client.components.events.ScreenChangeEvent;
import com.infirmarium.client.components.events.handlers.ScreenChangeEventHandler;
import com.infirmarium.client.components.presenters.screens.PatientsScreenPresenter;
import com.infirmarium.client.core.components.presenters.screens.AbstractScreenPresenter;
import com.infirmarium.client.gin.InfirmariumGinjector;

public class AppPresenter {
	private HasWidgets container;
	private AbstractScreenPresenter<?> currentScreen;
	private NavigationPanelPresenter navigation;
	private EventBus eventBus;
	private final InfirmariumGinjector injector = GWT
			.create(InfirmariumGinjector.class);

	@Inject
	public AppPresenter(final DispatchAsync dispatcher,
			final PatientsScreenPresenter patientsScreenPresenter,
			NavigationPanelPresenter navigation, EventBus eventBus) {
		this.currentScreen = patientsScreenPresenter;
		this.navigation = navigation;
		this.eventBus = eventBus;

		eventBus.addHandler(ScreenChangeEvent.TYPE,
				new ScreenChangeEventHandler() {
					@Override
					public void onScreenChange(ScreenChangeEvent event) {
						changeScreen(event.getNewScreenClass());
					}
				});
	}

	@SuppressWarnings("unchecked")
	public void changeScreen(Class newScreenClass) {
		Object newScreen = injector.getPatientsScreen();
		currentScreen.unbind();
		currentScreen = (AbstractScreenPresenter<?>) newScreen;
		showMain();
		// appPresenter.changeScreen((AbstractScreenPresenter<?>)
		// createdScreen);
	}

	private void showMain() {
		container.clear();
		container.add(currentScreen.getDisplay().asWidget());
		container.add(navigation.getDisplay().asWidget());
	}

	public void go(final HasWidgets container) {
		this.container = container;
		showMain();
	}

}