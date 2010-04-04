package com.infirmarium.client.components.elements.simple;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TitledDescriptionWidget extends Composite {

	private static TitledDescriptionWidgetUiBinder uiBinder = GWT
			.create(TitledDescriptionWidgetUiBinder.class);

	interface TitledDescriptionWidgetUiBinder extends
			UiBinder<Widget, TitledDescriptionWidget> {
	}

	@UiField
	public SpanElement titleSpan;
	@UiField
	public SpanElement textSpan;

	public TitledDescriptionWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setText(String description) {
		textSpan.setInnerText(description);
	}

	public void setTitle(String title) {
		titleSpan.setInnerText(title);
	}

}
