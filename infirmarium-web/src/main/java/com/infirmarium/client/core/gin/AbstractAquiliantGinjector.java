package com.infirmarium.client.core.gin;

import net.customware.gwt.dispatch.client.DefaultDispatchAsync;

import com.google.gwt.inject.client.Ginjector;
import com.infirmarium.client.components.elements.RootWidget;

public interface AbstractAquiliantGinjector extends Ginjector {

	// void injectMembers(DepartmentScreen departmentScreen);


	RootWidget getRootWidget();

	DefaultDispatchAsync getDefaultDispatchAsync();
}