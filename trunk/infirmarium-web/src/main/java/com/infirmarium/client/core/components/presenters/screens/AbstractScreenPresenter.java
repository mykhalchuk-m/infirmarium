package com.infirmarium.client.core.components.presenters.screens;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.inject.Inject;

public abstract class AbstractScreenPresenter<D extends AbstractScreenPresenter.Display>
		extends WidgetPresenter<D> {

	public interface Display extends WidgetDisplay {
		public void destroy();
	}

	protected final DispatchAsync dispatcher;
	public static final Place PLACE = new Place("PatientScreen");

	@Inject
	public AbstractScreenPresenter(final D display, EventBus eventBus,
			final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;

		bind();
	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
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
