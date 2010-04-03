package com.infirmarium.client.components.elements;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.gin.GinManager;

public class RootWidget extends Composite {

	private static RootWidgetUiBinder uiBinder = GWT
			.create(RootWidgetUiBinder.class);

	interface RootWidgetUiBinder extends UiBinder<Widget, RootWidget> {
	}

	@UiField
	public NavigationWidget navigationPanel;
	@UiField
	public ScreenManagerWidget screenPanel;

	private EventBus eventBus = GinManager.get().getEventBus();

	public RootWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		screenPanel.bindNavigation(navigationPanel);
	}

}
