package com.infirmarium.client.components.elements.simple;

import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.infirmarium.client.components.elements.screens.subscreens.PatientDetailsScreen;
import com.infirmarium.client.components.events.SubScreenShownEvent;
import com.infirmarium.client.components.events.TitleScreenShownEvent;
import com.infirmarium.client.core.components.elements.screens.BaseScreen;
import com.infirmarium.client.core.components.elements.screens.SubScreen;
import com.infirmarium.client.core.components.elements.screens.TitleScreen;
import com.infirmarium.client.gin.GinManager;

public class SubPageNavigationLink extends Composite {

	private static SubPageNavigationLinkUiBinder uiBinder = GWT
			.create(SubPageNavigationLinkUiBinder.class);

	interface SubPageNavigationLinkUiBinder extends
			UiBinder<Widget, SubPageNavigationLink> {
	}

	private EventBus eventBus = GinManager.get().getEventBus();

	@UiField
	public Hyperlink text;
	@UiField
	public HTMLPanel nextIcon;
	private boolean blocked = false;

	private BaseScreen<?> referedScreen;

	public SubPageNavigationLink(BaseScreen<?> referedScreen) {
		initWidget(uiBinder.createAndBindUi(this));
		setReferedScreen(referedScreen);
	}

	public void setLabel(String newLabel) {
		text.setText(newLabel);
	}

	public BaseScreen<?> getReferedScreen() {
		return referedScreen;
	}

	public void setReferedScreen(BaseScreen<?> referedScreen) {
		this.referedScreen = referedScreen;
		text.setText(referedScreen.getName());
	}

	public void unblock() {
		blocked = false;
		text.removeStyleName("inf-blocked-nav-link");
		nextIcon.setVisible(true);

	}

	public void block() {
		blocked = true;
		text.addStyleName("inf-blocked-nav-link");
		nextIcon.setVisible(false);
	}

	@UiHandler("text")
	void handleClick(ClickEvent e) {
		if (!blocked) {
			if (referedScreen instanceof SubScreen) {
				eventBus.fireEvent(new SubScreenShownEvent(
						(SubScreen) referedScreen));
			}
			if (referedScreen instanceof TitleScreen) {
				eventBus.fireEvent(new TitleScreenShownEvent(referedScreen));
			}
		}
	}
}
