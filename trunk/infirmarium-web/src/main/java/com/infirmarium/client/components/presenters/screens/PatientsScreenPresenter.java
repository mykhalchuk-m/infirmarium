package com.infirmarium.client.components.presenters.screens;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;

import com.google.inject.Inject;
import com.infirmarium.client.components.presenters.PatientDetailsPresenter;
import com.infirmarium.client.components.presenters.PatientsTablePresenter;
import com.infirmarium.client.core.components.presenters.screens.AbstractScreenPresenter;

public class PatientsScreenPresenter extends
		AbstractScreenPresenter<PatientsScreenPresenter.Display> {

	public interface Display extends AbstractScreenPresenter.Display {
	}

	private PatientDetailsPresenter patientDetailsPresenter;
	private PatientsTablePresenter patientsTablePresenter;

	public static final Place PLACE = new Place("PatientScreen");

	@Inject
	public PatientsScreenPresenter(final Display display, EventBus eventBus,
			final DispatchAsync dispatcher,
			PatientDetailsPresenter patientDetailsPresenter,
			PatientsTablePresenter patientsTablePresenter) {
		super(display, eventBus, dispatcher);
		this.patientDetailsPresenter = patientDetailsPresenter;
		this.patientsTablePresenter = patientsTablePresenter;
		bind();
	}

	public PatientDetailsPresenter getPatientDetailsPresenter() {
		return patientDetailsPresenter;
	}

	public PatientsTablePresenter getPatientsTablePresenter() {
		return patientsTablePresenter;
	}

}
