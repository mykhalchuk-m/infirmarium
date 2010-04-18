package com.infirmarium.client.core.components.elements.screens;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.interfaces.InitiableWidget;
import com.infirmarium.client.components.elements.simple.IconedLinkWidget;
import com.infirmarium.client.gin.GinManager;

public abstract class BaseScreen extends Composite implements InitiableWidget {
	protected static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private String navigationStyleName;
	private String name;
	private String description;

	private boolean initialized = false;
	// this field is public because of uibinder
	@UiField
	public AbstractScreenLayout screen;
	protected final DispatchAsync dispatcher = GinManager.get()
			.getDefaultDispatchAsync();
	protected EventBus eventBus = GinManager.get().getEventBus();

	public BaseScreen(String navigationStyleName, String name,
			String description) {
		this.navigationStyleName = navigationStyleName;
		this.name = name;
		this.description = description;
	}

	public void addWidgetToTopSlot(Widget widget) {
		screen.topSlot.add(widget);
	}

	public void addWidgetToContentSlot(Widget widget) {
		screen.contentSlot.add(widget);
	}

	@Override
	public void init() {
		screen.icon.setIcon(navigationStyleName);
		screen.description.setText(description);
		screen.description.setTitle(name);

		setInitialized(true);
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
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
		screen.linkSheet.addControlLink(newLink);
	}
}
