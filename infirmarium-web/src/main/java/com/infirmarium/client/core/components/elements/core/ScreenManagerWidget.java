package com.infirmarium.client.core.components.elements.core;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.core.components.elements.screens.SubScreen;
import com.infirmarium.client.core.components.elements.simple.SubPageNavigation;
import com.infirmarium.client.core.components.events.SubScreenShownEvent;
import com.infirmarium.client.core.components.events.TitleScreenShownEvent;
import com.infirmarium.client.core.components.events.handlers.SubScreenShownEventHandler;
import com.infirmarium.client.core.components.events.handlers.TitleScreenShownEventHandler;
import com.infirmarium.client.gin.GinManager;

public class ScreenManagerWidget extends Composite {

	private static ScreenManagerWidgetUiBinder uiBinder = GWT
			.create(ScreenManagerWidgetUiBinder.class);

	interface ScreenManagerWidgetUiBinder extends
			UiBinder<Widget, ScreenManagerWidget> {
	}

	private EventBus eventBus = GinManager.get().getEventBus();

	@UiField
	public DeckPanel mainPanel;
	@UiField
	public SubPageNavigation subPageNavigationWidget;

	public ScreenManagerWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		eventBus.addHandler(TitleScreenShownEvent.TYPE,
				new TitleScreenShownEventHandler() {
					@Override
					public void onTitleScreenShownChange(
							TitleScreenShownEvent event) {
						mainPanel.clear();
						if (!event.getReferedScreen().isInitialized()) {
							event.getReferedScreen().init();
						}
						mainPanel.add(event.getReferedScreen());
						subPageNavigationWidget.clear();
						subPageNavigationWidget.addScreen(event
								.getReferedScreen());
						mainPanel.showWidget(0);
					}

				});
		eventBus.addHandler(SubScreenShownEvent.TYPE,
				new SubScreenShownEventHandler() {
					@Override
					public void onSubScreenShown(SubScreenShownEvent event) {
						SubScreen referedScreen = event.getReferedScreen();
						int widgetIndex = mainPanel
								.getWidgetIndex(referedScreen);
						if (widgetIndex < 0) {
							if (!referedScreen.isInitialized()) {
								referedScreen.init();
							}
							mainPanel.add(event.getReferedScreen());
							subPageNavigationWidget.addScreen(referedScreen);
							mainPanel
									.showWidget(mainPanel.getWidgetCount() - 1);
						} else {
							mainPanel.showWidget(widgetIndex);
							for (int i = mainPanel.getWidgetCount() - 1; i > widgetIndex; i--) {
								mainPanel.remove(i);
							}
							subPageNavigationWidget
									.backwardScreen(referedScreen);
						}
					}
				});

	}

}
