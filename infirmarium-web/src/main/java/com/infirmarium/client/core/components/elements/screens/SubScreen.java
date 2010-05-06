package com.infirmarium.client.core.components.elements.screens;

import com.google.gwt.user.client.ui.Widget;

public class SubScreen extends BaseScreen<SubScreenLayout> {

	public SubScreen(String name) {
		super(name);
	}

	public void addWidgetToContentSlot(Widget widget) {
		layout.contentSlot.add(widget);
	}

	@Override
	public void init() {
		super.init();
	}
}
