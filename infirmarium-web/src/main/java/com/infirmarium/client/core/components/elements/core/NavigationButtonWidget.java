package com.infirmarium.client.core.components.elements.core;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;
import com.infirmarium.client.core.components.elements.simple.LargeIconWidget;
import com.infirmarium.client.core.components.events.TitleScreenShownEvent;
import com.infirmarium.client.gin.GinManager;

public class NavigationButtonWidget extends LargeIconWidget implements
		com.google.gwt.event.dom.client.HasClickHandlers {

	private EventBus eventBus = GinManager.get().getEventBus();

	public NavigationButtonWidget(final TitleScreen referedScreen) {
		super();
		setIcon(referedScreen.getNavigationIconName());
		addStyleName("inf-navigation-button");
		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new TitleScreenShownEvent(referedScreen));
			}
		});
	}

}
