package com.infirmarium.client.components.elements;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.interfaces.InitiableWidget;
import com.infirmarium.client.components.elements.screens.DepartmentScreen;
import com.infirmarium.client.components.elements.screens.PatientScreen;
import com.infirmarium.client.components.events.ScreenChangeEvent;
import com.infirmarium.client.components.events.handlers.ScreenChangeEventHandler;
import com.infirmarium.client.gin.GinManager;

public class ScreenManagerWidget extends Composite {

	private static ScreenManagerWidgetUiBinder uiBinder = GWT
			.create(ScreenManagerWidgetUiBinder.class);

	interface ScreenManagerWidgetUiBinder extends
			UiBinder<Widget, ScreenManagerWidget> {
	}

	@UiField
	public DeckPanel mainPanel;
	private NavigationWidget navigation;

	public EventBus eventBus = GinManager.get().getEventBus();

	// private HashMap<Integer, String> screens = new HashMap<Integer,
	// String>();

	public ScreenManagerWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		addScreen(new DepartmentScreen());
		addScreen(new PatientScreen());
		getScreen(0).init();
		mainPanel.showWidget(0);
		eventBus.addHandler(ScreenChangeEvent.TYPE,
				new ScreenChangeEventHandler() {
					@Override
					public void onScreenChange(ScreenChangeEvent event) {
						InitiableWidget screen = getScreen(event.getScreenId());
						if (!screen.isInitialized()) {
							screen.init();
						}
						mainPanel.showWidget(event.getScreenId());
					}

				});
	}

	private void addScreen(Widget screen) {
		mainPanel.add(screen);
	}

	public void setNavigation(NavigationWidget navigation) {
		this.navigation = navigation;
		int screenId = 0;
		for (Widget widget : mainPanel) {
			NavigationButtonWidget navigationButton = new NavigationButtonWidget(
					screenId);
			navigation.add(navigationButton);
			screenId++;
		}
	}

	public InitiableWidget getScreen(int screenId) {
		return (InitiableWidget) mainPanel.getWidget(screenId);
	}
}
