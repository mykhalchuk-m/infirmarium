package com.infirmarium.client.components.elements.simple;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class IconedLinkWidget extends Composite implements
		com.google.gwt.event.dom.client.HasClickHandlers {

	private static IconedLinkUiBinder uiBinder = GWT
			.create(IconedLinkUiBinder.class);

	interface IconedLinkUiBinder extends UiBinder<Widget, IconedLinkWidget> {
	}

	@UiField
	public SmallIconWidget icon;
	@UiField
	public Label text;

	public IconedLinkWidget() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	public void setIcon(String iconStyle) {
		icon.setIcon(iconStyle);
	}

	public void setText(String text) {
		this.text.setText(text);
	}

}
