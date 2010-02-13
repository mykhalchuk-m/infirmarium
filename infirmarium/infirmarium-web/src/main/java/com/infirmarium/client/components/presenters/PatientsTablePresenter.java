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
import com.infirmarium.client.components.events.GetPersonsEvent;
import com.infirmarium.shared.GetPersonsCommand;
import com.infirmarium.shared.results.GetPersonsCommandResult;

public class PatientsTablePresenter extends
		WidgetPresenter<PatientsTablePresenter.Display> {

	public interface Display extends WidgetDisplay {
		public HasValue<String> getName();

		public HasClickHandlers getSend();
	}

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	public static final Place PLACE = new Place("Greeting");
	private final DispatchAsync dispatcher;
	// FUDGE FACTOR! Although this is not used, having GIN pass the object
	// to this class will force its instantiation and therefore will make the
	// response presenter listen for events (via bind()). This is not a very
	// good way to
	// achieve this, but I wanted to put something together quickly - sorry!
	private final PatientsTablePresenter patientsTablePresenter;

	@Inject
	public PatientsTablePresenter(final Display display,
			final EventBus eventBus, final DispatchAsync dispatcher,
			PatientsTablePresenter patientsTablePresenter) {
		super(display, eventBus);
		this.patientsTablePresenter = patientsTablePresenter;
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
						Log.error("Handle Failure:", cause);

						Window.alert(SERVER_ERROR);
					}

					@Override
					protected void handleSuccess(
							final GetPersonsCommandResult result) {
						// take the result from the server and notify client
						// interested components
						eventBus.fireEvent(new GetPersonsEvent(result));
					}

				});
	}

	@Override
	protected void onBind() {
		// 'display' is a final global field containing the Display passed into
		// the constructor.
		display.getSend().addClickHandler(new ClickHandler() {
			public void onClick(final ClickEvent event) {
				doSend();
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

		if (name != null) {
			display.getName().setValue(name);
		}
	}
}