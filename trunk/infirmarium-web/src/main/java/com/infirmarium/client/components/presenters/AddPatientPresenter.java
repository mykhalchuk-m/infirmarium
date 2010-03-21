package com.infirmarium.client.components.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;
import com.infirmarium.client.components.events.AddPatientEvent;
import com.infirmarium.client.components.events.RefreshDataEvent;
import com.infirmarium.client.components.events.handlers.AddPatientEventHandler;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.server.shared.AddPersonCommand;
import com.infirmarium.server.shared.results.AddPersonCommandResult;

public class AddPatientPresenter extends
		WidgetPresenter<AddPatientPresenter.Display> {

	public interface Display extends WidgetDisplay {
		HasClickHandlers getCancel();

		HasClickHandlers getAdd();

		HasValue<String> getName();

		void setHeader(String header);

		void hide();

		void show();
	}

	private Person person;
	protected final DispatchAsync dispatcher;
	public static final Place PLACE = new Place("AddPatient");
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	@Inject
	public AddPatientPresenter(final Display display, EventBus eventBus,
			final DispatchAsync dispatcher, Person person) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		this.person = person;
		bind();
	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
		eventBus.addHandler(AddPatientEvent.TYPE, new AddPatientEventHandler() {

			@Override
			public void openAddPersonPresenter(AddPatientEvent event) {
				display.show();
			}
		});
		display.getCancel().addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				display.hide();
			}
		});
		display.getAdd().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				person = new Person();
				person.setFirstName(display.getName().getValue());
				person.setLastName(display.getName().getValue());
				savePatient(person.getFirstName());
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

	private void savePatient(String person) {
		dispatcher.execute(new AddPersonCommand(person),
				new DisplayCallback<AddPersonCommandResult>(display) {
					@Override
					protected void handleFailure(final Throwable cause) {
						Log.info("Handle Failure:", cause);
						Window.alert(SERVER_ERROR);
					}

					@Override
					protected void handleSuccess(
							final AddPersonCommandResult result) {
						display.getName().setValue("");
						display.hide();
						eventBus.fireEvent(new RefreshDataEvent());

					}

				});
	}

}
