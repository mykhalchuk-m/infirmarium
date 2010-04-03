package com.infirmarium.client.components.elements;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.infirmarium.client.components.elements.simple.LargeIconWidget;
import com.infirmarium.client.components.events.ScreenChangeEvent;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;
import com.infirmarium.client.gin.GinManager;

public class NavigationButtonWidget extends LargeIconWidget implements
		com.google.gwt.event.dom.client.HasClickHandlers {

	private EventBus eventBus = GinManager.get().getEventBus();

	public NavigationButtonWidget(final BaseScreen referedScreen) {
		super();
		addStyleName("inf-navigation-button");
		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new ScreenChangeEvent(referedScreen));
			}
		});
	}

}
