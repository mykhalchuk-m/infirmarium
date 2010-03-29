package com.infirmarium.client.core.components.elements.screens;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AbstractScreen extends Composite {

	private static AbstractScreenUiBinder uiBinder = GWT
			.create(AbstractScreenUiBinder.class);

	interface AbstractScreenUiBinder extends UiBinder<Widget, AbstractScreen> {
	}

	// private String name = "";

	@UiField
	public HorizontalPanel topSlot;
	@UiField
	public HorizontalPanel contentSlot;
	@UiField
	public HorizontalPanel footerSlot;

	public DispatchAsync dispatcher;

	public AbstractScreen() {
		initWidget(uiBinder.createAndBindUi(this));

	}

}
