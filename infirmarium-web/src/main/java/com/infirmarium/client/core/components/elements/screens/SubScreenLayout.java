package com.infirmarium.client.core.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class SubScreenLayout extends Composite {

	private static TitleScreenLayoutUiBinder uiBinder = GWT
			.create(TitleScreenLayoutUiBinder.class);

	interface TitleScreenLayoutUiBinder extends
			UiBinder<Widget, SubScreenLayout> {
	}

	@UiField
	public FlowPanel contentSlot;

	public SubScreenLayout() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
