package com.infirmarium.client.core.gin;

import net.customware.gwt.dispatch.client.DefaultDispatchAsync;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.Ginjector;
import com.infirmarium.client.components.elements.screens.DepartmentScreen;
import com.infirmarium.client.components.elements.screens.PatientScreen;
import com.infirmarium.client.internationalization.InfirmariumMessages;

public interface AbstractAquiliantGinjector extends Ginjector {

	void injectMembers(DepartmentScreen departmentScreen);

	void injectMembers(PatientScreen patientScreen);

	EventBus getEventBus();

	DefaultDispatchAsync getDefaultDispatchAsync();

	InfirmariumMessages InfirmariumMessages();

}