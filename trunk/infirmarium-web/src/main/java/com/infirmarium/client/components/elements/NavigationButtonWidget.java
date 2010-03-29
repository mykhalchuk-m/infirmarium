package com.infirmarium.client.components.elements;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.events.ScreenChangeEvent;
import com.infirmarium.client.gin.GinManager;

public class NavigationButtonWidget extends Composite implements
		com.google.gwt.event.dom.client.HasClickHandlers {

	private static NavigationButtonWidgetUiBinder uiBinder = GWT
			.create(NavigationButtonWidgetUiBinder.class);

	private EventBus eventBus = GinManager.get().getEventBus();

	interface NavigationButtonWidgetUiBinder extends
			UiBinder<Widget, NavigationButtonWidget> {
	}

	@UiField
	public SimplePanel base;

	private int screenId;

	public NavigationButtonWidget(final int screenId) {
		initWidget(uiBinder.createAndBindUi(this));
		this.screenId = screenId;
		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				eventBus.fireEvent(new ScreenChangeEvent(screenId));
			}
		});
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
}
