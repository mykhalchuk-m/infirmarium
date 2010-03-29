package com.infirmarium.client.components.presenters;

import java.util.ArrayList;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.infirmarium.client.components.events.ScreenChangeEvent;
import com.infirmarium.client.components.model.NavigationButtonBinder;
import com.infirmarium.client.components.presenters.screens.PatientsScreenPresenter;

public class NavigationPanelPresenter extends
		WidgetPresenter<NavigationPanelPresenter.Display> {

	public interface Display extends WidgetDisplay {

		void addNavigationWidget(ClickHandler clickHandler,
				String imageStyleName);
	}

	// sorry Joshua
	private ArrayList<NavigationButtonBinder> binders = new ArrayList<NavigationButtonBinder>();
	// final private AppPresenter appPresenter;
	protected final DispatchAsync dispatcher;
	public static final Place PLACE = new Place("PatientDetails");

	@Inject
	public NavigationPanelPresenter(final Display display, EventBus eventBus,
			final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		// this.appPresenter = appPresenter;
		binders.add(new NavigationButtonBinder(PatientsScreenPresenter.class,
				"inf-navigation-patients"));
		bind();
		Log.info("starting details presenter");
	}

	@Override
	public Place getPlace() {
		return PLACE;
	} 

	@Override
	protected void onBind() {
		Log.info("Binding navigation presenter.");
		for (final NavigationButtonBinder binder : binders) {
			display.addNavigationWidget(new ClickHandler() {
				public void onClick(final ClickEvent event) {
					ScreenChangeEvent screenChangeEvent = new ScreenChangeEvent();
//					screenChangeEvent
//							.setNewScreenClass(binder.getScreenClass());
//					eventBus.fireEvent(screenChangeEvent);
				}
			}, binder.getVisualClassName());
		}

	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {

	}

	@Override
	protected void onUnbind() {
	}

	@Override
	public void refreshDisplay() {
	}

	@Override
	public void revealDisplay() {
	}

}
