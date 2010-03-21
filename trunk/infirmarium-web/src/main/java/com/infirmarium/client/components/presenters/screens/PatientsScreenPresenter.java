package com.infirmarium.client.components.presenters.screens;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;

import com.google.inject.Inject;
import com.infirmarium.client.components.presenters.AddPatientPresenter;
import com.infirmarium.client.components.presenters.PatientDetailsPresenter;
import com.infirmarium.client.components.presenters.PatientsTablePresenter;
import com.infirmarium.client.core.components.presenters.screens.AbstractScreenPresenter;

public class PatientsScreenPresenter extends
		AbstractScreenPresenter<PatientsScreenPresenter.Display> {

	public interface Display extends AbstractScreenPresenter.Display {
	}

	private PatientDetailsPresenter patientDetailsPresenter;
	private PatientsTablePresenter patientsTablePresenter;
	private AddPatientPresenter addPatientPresenter;

	public static final Place PLACE = new Place("PatientScreen");

	@Inject
	public PatientsScreenPresenter(final Display display, EventBus eventBus,
			final DispatchAsync dispatcher,
			PatientDetailsPresenter patientDetailsPresenter,
			PatientsTablePresenter patientsTablePresenter,
			AddPatientPresenter addPatientPresenter) {
		super(display, eventBus, dispatcher);
		this.patientDetailsPresenter = patientDetailsPresenter;
		com.allen_sauer.gwt.log.client.Log.info(patientDetailsPresenter.toString());
		this.patientsTablePresenter = patientsTablePresenter;
		com.allen_sauer.gwt.log.client.Log.info(patientsTablePresenter.toString());
		this.addPatientPresenter = addPatientPresenter;
		com.allen_sauer.gwt.log.client.Log.info(addPatientPresenter.toString());
		bind();
	}

	public AddPatientPresenter getAddPatientPresenter() {
		return addPatientPresenter;
	}

	public PatientDetailsPresenter getPatientDetailsPresenter() {
		return patientDetailsPresenter;
	}

	public PatientsTablePresenter getPatientsTablePresenter() {
		return patientsTablePresenter;
	}

}
