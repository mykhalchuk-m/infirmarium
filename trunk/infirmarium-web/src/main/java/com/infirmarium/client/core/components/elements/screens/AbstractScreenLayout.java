package com.infirmarium.client.core.components.elements.screens;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.simple.ControlLinkSheetWidget;
import com.infirmarium.client.components.elements.simple.LargeIconWidget;
import com.infirmarium.client.components.elements.simple.TitledDescriptionWidget;

public class AbstractScreenLayout extends Composite {

	private static AbstractScreenUiBinder uiBinder = GWT
			.create(AbstractScreenUiBinder.class);

	interface AbstractScreenUiBinder extends
			UiBinder<Widget, AbstractScreenLayout> {
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

	public AbstractScreenLayout() {

		initWidget(uiBinder.createAndBindUi(this));
	}

}
