package com.infirmarium.client.core.components.elements.simple;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class SmallIconWidget extends Composite implements
		com.google.gwt.event.dom.client.HasClickHandlers {

	private static NavigationButtonWidgetUiBinder uiBinder = GWT
			.create(NavigationButtonWidgetUiBinder.class);

	interface NavigationButtonWidgetUiBinder extends
			UiBinder<Widget, SmallIconWidget> {
	}

	@UiField
	public SimplePanel base;
	@UiField
	public SimplePanel icon;

	private String iconStyleName = "";

	public SmallIconWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	public void setIcon(String iconStyle) {
		if (!"".equals(iconStyleName)) {
			icon.removeStyleName(iconStyleName);
		}
		icon.addStyleName(iconStyle);
		iconStyleName = iconStyle;
	}
}
