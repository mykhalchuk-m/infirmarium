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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.infirmarium.client.components.events.AddPatientEvent;
import com.infirmarium.client.components.events.GetPersonDetailsEvent;
import com.infirmarium.client.components.events.GetPersonsEvent;
import com.infirmarium.client.components.events.RefreshDataEvent;
import com.infirmarium.client.components.events.handlers.PersonsEventHandler;
import com.infirmarium.client.components.events.handlers.RefreshDataEventHandler;
import com.infirmarium.client.components.model.records.PersonRecord;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.server.shared.GetPersonDetailsCommand;
import com.infirmarium.server.shared.GetPersonsCommand;
import com.infirmarium.server.shared.results.GetPersonDetailsCommandResult;
import com.infirmarium.server.shared.results.GetPersonsCommandResult;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;

public class PatientsTablePresenter extends
		WidgetPresenter<PatientsTablePresenter.Display> {

	public interface Display extends WidgetDisplay {

		public ListGrid getListGrid();

		public HasClickHandlers getAddPatient();
	}

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

	/**
	 * Try to get person details
	 */
	private void doSendGetPersonDetailsAction(Integer id) {
		Log.info("Calling doSendGetPersonDetailsAction");

		dispatcher.execute(new GetPersonDetailsCommand(id),
				new DisplayCallback<GetPersonDetailsCommandResult>(display) {

					@Override
					protected void handleFailure(final Throwable cause) {
						Log.info("Handle Failure:", cause);
						Window.alert(SERVER_ERROR);
					}

					@Override
					protected void handleSuccess(
							final GetPersonDetailsCommandResult result) {
						// take the result from the server and notify client
						// interested components
						Log.info("Recieved person details");
						Log.info(result.getName() + " " + result.getMessage());
						eventBus.fireEvent(new GetPersonDetailsEvent(result));
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
		eventBus.addHandler(RefreshDataEvent.TYPE,new RefreshDataEventHandler() {
			
			@Override
			public void refreshData(RefreshDataEvent event) {
				Log.info("refreshing persons.");
				doSend();
			}
		});
		display.getListGrid().addCellClickHandler(new CellClickHandler() {

			@Override
			public void onCellClick(CellClickEvent event) {
				Log.info("setting click handler");
				int selectedRow = event.getRowNum();

				if (selectedRow >= 0) {
					Log.info("selected=" + selectedRow);
					Integer id = selectedRow;
					doSendGetPersonDetailsAction(id);
				}
			}

		});
		display.getAddPatient().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new AddPatientEvent());
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