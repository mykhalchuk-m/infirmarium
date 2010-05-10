package com.infirmarium.client.core.components.elements.core;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.inject.Inject;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;
import com.infirmarium.client.core.components.elements.simple.LargeIconWidget;
import com.infirmarium.client.core.components.events.TitleScreenShownEvent;

public class NavigationButtonWidget extends LargeIconWidget implements
		com.google.gwt.event.dom.client.HasClickHandlers {

	private TitleScreen referedScreen;

	public NavigationButtonWidget(final TitleScreen referedScreen) {
		setReferedScreenAndInitIcon(referedScreen);
	}

	public NavigationButtonWidget() {
		addStyleName("inf-navigation-button");
	}

	/** This method is run with the No-Arg constructor */
	public void setReferedScreenAndInitIcon(final TitleScreen referedScreen) {
		setIcon(referedScreen.getNavigationIconName());
		this.referedScreen = referedScreen;
	}

	@Inject
	void construct(final HandlerManager eventBus) {
		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new TitleScreenShownEvent(referedScreen));
			}
		});
	}

}
