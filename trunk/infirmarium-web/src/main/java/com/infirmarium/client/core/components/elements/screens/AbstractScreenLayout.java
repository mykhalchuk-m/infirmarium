package com.infirmarium.client.core.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.simple.LargeIconWidget;

public class AbstractScreenLayout extends Composite {

	private static AbstractScreenUiBinder uiBinder = GWT
			.create(AbstractScreenUiBinder.class);

	interface AbstractScreenUiBinder extends
			UiBinder<Widget, AbstractScreenLayout> {
	}

	@UiField
	public HorizontalPanel topSlot;
	@UiField
	public SimplePanel contentSlot;
	@UiField
	public LargeIconWidget icon;

	public AbstractScreenLayout() {

		initWidget(uiBinder.createAndBindUi(this));
	}

}
