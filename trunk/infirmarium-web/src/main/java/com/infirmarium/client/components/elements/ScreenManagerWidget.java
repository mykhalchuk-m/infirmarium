package com.infirmarium.client.components.elements;

import java.util.ArrayList;
import java.util.List;

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
import com.infirmarium.client.core.components.elements.screens.BaseScreen;
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

	private List<BaseScreen> screens = new ArrayList<BaseScreen>();

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
						InitiableWidget screen = event.getReferedScreen();
						if (!screen.isInitialized()) {
							screen.init();
						}
						mainPanel.showWidget(screens.indexOf(event
								.getReferedScreen()));
					}

				});
	}

	private void addScreen(BaseScreen screen) {
		screens.add(screen);
		mainPanel.add(screen);
	}

	public void bindNavigation(NavigationWidget navigation) {
		this.navigation = navigation;
		for (BaseScreen screen : screens) {
			NavigationButtonWidget navigationButton = new NavigationButtonWidget(
					screen);
			navigationButton.setIcon(screen.getNavigationIconName());
			navigation.add(navigationButton);
		}
	}

	public InitiableWidget getScreen(int screenId) {
		return (InitiableWidget) mainPanel.getWidget(screenId);
	}
}
