package com.infirmarium.client.core.components.elements.simple;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;

public class SubPageNavigation extends Composite {

	private static SubPageNavigationUiBinder uiBinder = GWT
			.create(SubPageNavigationUiBinder.class);

	interface SubPageNavigationUiBinder extends
			UiBinder<Widget, SubPageNavigation> {
	}

	@UiField
	public FlowPanel panel;
	private Map<BaseScreen<?>, SubPageNavigationLink> navigations = new HashMap<BaseScreen<?>, SubPageNavigationLink>();
	private SubPageNavigationLink lastLink;

	public SubPageNavigation() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void addScreen(BaseScreen<?> screen) {
		SubPageNavigationLink link = new SubPageNavigationLink(screen);
		navigations.put(screen, link);
		if (lastLink != null) {
			lastLink.unblock();
		}
		link.block();
		lastLink = link;
		panel.add(link);
	}

	public void clear() {
		panel.clear();
		lastLink = null;
		navigations.clear();
	}

	public void backwardScreen(BaseScreen<?> screen) {
		SubPageNavigationLink link = navigations.get(screen);
		link.block();
		lastLink = link;
		int widgetIndex = panel.getWidgetIndex(link);
		for (int i = panel.getWidgetCount() - 1; i > widgetIndex; i--) {
			removeLink(i);
		}
	}

	private void removeLink(int i) {
		Widget deletedWidget = panel.getWidget(i);
		panel.remove(i);
		navigations.remove(deletedWidget);
	}

}
