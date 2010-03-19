package com.infirmarium.client.components.model;

import com.infirmarium.client.core.components.presenters.screens.AbstractScreenPresenter;

public class NavigationButtonBinder {
	private Class<? extends AbstractScreenPresenter<?>> screenClass;
	private String visualClassName;

	public NavigationButtonBinder(
			Class<? extends AbstractScreenPresenter<?>> screenClass,
			String imageName) {
		super();
		this.screenClass = screenClass;
		this.visualClassName = imageName;

	}

	public Class<? extends AbstractScreenPresenter<?>> getScreenClass() {
		return screenClass;
	}

	public void setScreenClass(
			Class<? extends AbstractScreenPresenter<?>> screenClass) {
		this.screenClass = screenClass;
	}

	public String getVisualClassName() {
		return visualClassName;
	}

	public void setVisualClassName(String visualClassName) {
		this.visualClassName = visualClassName;
	}

}
