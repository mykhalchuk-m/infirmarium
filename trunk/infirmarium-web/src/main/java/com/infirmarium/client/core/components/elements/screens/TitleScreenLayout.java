package com.infirmarium.client.core.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.core.components.elements.simple.ControlLinkSheetWidget;
import com.infirmarium.client.core.components.elements.simple.LargeIconWidget;
import com.infirmarium.client.core.components.elements.simple.TitledDescriptionWidget;

public class TitleScreenLayout extends Composite {

	private static TitleScreenLayoutUiBinder uiBinder = GWT
			.create(TitleScreenLayoutUiBinder.class);

	interface TitleScreenLayoutUiBinder extends
			UiBinder<Widget, TitleScreenLayout> {
	}

	@UiField
	public FlowPanel topSlot;
	@UiField
	public SimplePanel contentSlot;
	@UiField
	public LargeIconWidget icon;
	@UiField
	public TitledDescriptionWidget description;
	@UiField
	public ControlLinkSheetWidget linkSheet;

	public TitleScreenLayout() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
