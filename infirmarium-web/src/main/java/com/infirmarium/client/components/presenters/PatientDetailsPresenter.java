package com.infirmarium.client.components.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;
import com.infirmarium.client.components.events.GetPersonDetailsEvent;
import com.infirmarium.client.components.events.handlers.PersonDetailsEventHandler;
import com.infirmarium.core.persistance.domain.Person;

public class PatientDetailsPresenter extends
		WidgetPresenter<PatientDetailsPresenter.Display> {

	public interface Display extends WidgetDisplay {
		HasClickHandlers getClose();

		void setHeader(String header);

		void setData(String data);

		void hide();

		void show();
	}

	private Person person;
	protected final DispatchAsync dispatcher;
	public static final Place PLACE = new Place("PatientDetails");

	@Inject
	public PatientDetailsPresenter(final Display display, EventBus eventBus,
			final DispatchAsync dispatcher, Person person) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		this.person = person;
		bind();
		Log.info("starting details presenter");
	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
		Log.info("Showing" + person.getFirstName() + " " + person.getLastName()
				+ "details");
		display.getClose().addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				display.hide();
			}
		});
		eventBus.addHandler(GetPersonDetailsEvent.TYPE,
				new PersonDetailsEventHandler() {

					@Override
					public void onGetPersonDetails(
							final GetPersonDetailsEvent event) {
						display.setHeader(event.getResult().getName());
						display.setData(event.getResult().getMessage());
						display.show();
					}

				});
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {

	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void revealDisplay() {
		// TODO Auto-generated method stub

	}

}
