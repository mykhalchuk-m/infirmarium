package com.infirmarium.client.core.components.elements.screens;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.core.components.elements.simple.IconedLinkWidget;

public class TitleScreen extends BaseScreen<TitleScreenLayout> {

	private String navigationStyleName;
	private String description;

	public TitleScreen(String name, String navigationStyleName,
			String description) {
		super(name);
		this.navigationStyleName = navigationStyleName;
		this.description = description;
	}

	public void addWidgetToTopSlot(Widget widget) {
		layout.topSlot.add(widget);
	}

	public void addWidgetToContentSlot(Widget widget) {
		layout.contentSlot.add(widget);
	}

	@Override
	public void init() {
		getLayout().icon.setIcon(navigationStyleName);
		getLayout().description.setText(getDescription());
		super.init();
	}

	public String getNavigationIconName() {
		return navigationStyleName;
	}

	public void addControlLink(String iconStyle, String text,
			ClickHandler handler) {
		IconedLinkWidget newLink = new IconedLinkWidget();
		newLink.setIcon(iconStyle);
		newLink.setText(text);
		if (handler != null) {
			newLink.addClickHandler(handler);
		}
		getLayout().linkSheet.addControlLink(newLink);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
