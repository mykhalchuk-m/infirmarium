package com.infirmarium.client.core.components.elements.screens;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.interfaces.InitiableWidget;
import com.infirmarium.client.gin.GinManager;

public abstract class BaseScreen<L extends Widget> extends Composite implements
		InitiableWidget {
	protected static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private String name;

	private boolean initialized = false;
	// this field is public because of uibinder
	@UiField
	public L layout;

	protected final DispatchAsync dispatcher = GinManager.get()
			.getDefaultDispatchAsync();
	protected EventBus eventBus = GinManager.get().getEventBus();

	public BaseScreen(String name) {
		this.name = name;
	}

	@Override
	public void init() {
		setInitialized(true);
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected L getLayout() {
		return layout;
	}

	protected void setLayout(L layout) {
		this.layout = layout;
	}

}
