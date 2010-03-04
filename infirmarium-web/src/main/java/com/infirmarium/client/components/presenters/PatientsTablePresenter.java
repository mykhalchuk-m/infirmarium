package com.infirmarium.client.components.presenters;

import java.util.List;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.infirmarium.client.components.events.GetPersonsEvent;
import com.infirmarium.client.components.events.handlers.PersonsEventHandler;
import com.infirmarium.client.components.model.records.PersonRecord;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.server.shared.GetPersonsCommand;
import com.infirmarium.server.shared.results.GetPersonsCommandResult;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGrid;

public class PatientsTablePresenter extends
		WidgetPresenter<PatientsTablePresenter.Display> {

	public interface Display extends WidgetDisplay {

		public ListGrid getListGrid();
	}

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	public static final Place PLACE = new Place("PatientsTable");
	private final DispatchAsync dispatcher;

	@Inject
	public PatientsTablePresenter(final Display display,
			final EventBus eventBus, final DispatchAsync dispatcher) {
		super(display, eventBus);
		// this.patientsTablePresenter = patientsTablePresenter;
		this.dispatcher = dispatcher;
		bind();
	}

	/**
	 * Try to send the greeting message
	 */
	private void doSend() {
		Log.info("Calling doSend");

		dispatcher.execute(new GetPersonsCommand(0),
				new DisplayCallback<GetPersonsCommandResult>(display) {

					@Override
					protected void handleFailure(final Throwable cause) {
						Log.info("Handle Failure:", cause);
						Window.alert(SERVER_ERROR);
					}

					@Override
					protected void handleSuccess(
							final GetPersonsCommandResult result) {
						// take the result from the server and notify client
						// interested components
						Log.info("Recieved.");
						eventBus.fireEvent(new GetPersonsEvent(result));
					}

				});
	}

	@Override
	protected void onBind() {
		// 'display' is a final global field containing the Display passed into
		// the constructor.
		Log.info("Sending.");
		doSend();
		eventBus.addHandler(GetPersonsEvent.TYPE, new PersonsEventHandler() {
			@Override
			public void onGetPersons(GetPersonsEvent event) {
				Log.info("Recieved persons.");
				GetPersonsCommandResult result = event.getResult();
				List<Person> personList = result.getPerson();
				// display.getName().setValue(personList.toString());
				Log.info(event.getResult().getPerson().toString());
				RecordList personRecordList = new RecordList();
				for (Person person : personList) {
					personRecordList.add(new PersonRecord(person));
				}
				display.getListGrid().setData(personRecordList);
				display.getListGrid().redraw();
			}
		});
	}

	@Override
	protected void onUnbind() {
		// Add unbind functionality here for more complex presenters.
	}

	public void refreshDisplay() {
		// This is called when the presenter should pull the latest data
		// from the server, etc. In this case, there is nothing to do.
	}

	public void revealDisplay() {
		// Nothing to do. This is more useful in UI which may be buried
		// in a tab bar, tree, etc.
	}

	/**
	 * Returning a place will allow this presenter to automatically trigger when
	 * '#Greeting' is passed into the browser URL.
	 */
	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onPlaceRequest(final PlaceRequest request) {
		// Grab the 'name' from the request and put it into the 'name' field.
		// This allows a tag of '#Greeting;name=Foo' to populate the name
		// field.
		final String name = request.getParameter("name", null);

		// TODO: implement me
	}
}