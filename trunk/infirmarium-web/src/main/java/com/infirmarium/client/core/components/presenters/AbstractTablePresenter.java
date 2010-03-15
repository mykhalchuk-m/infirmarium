package com.infirmarium.client.core.components.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.inject.Inject;

public abstract class AbstractTablePresenter<D extends AbstractTablePresenter.Display>
		extends WidgetPresenter<D> {

	public interface Display extends WidgetDisplay {
	}

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	protected final DispatchAsync dispatcher;

	@Inject
	public AbstractTablePresenter(final D display, final EventBus eventBus,
			final DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		bind();// onBind is called
	}

	@Override
	protected abstract void onBind();

	@Override
	protected void onUnbind() {
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
	public abstract Place getPlace();

	@Override
	protected abstract void onPlaceRequest(final PlaceRequest request);
}