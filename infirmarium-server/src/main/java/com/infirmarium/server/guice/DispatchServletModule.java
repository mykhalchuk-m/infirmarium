package com.infirmarium.server.guice;

import net.customware.gwt.dispatch.server.service.DispatchServiceServlet;

import com.google.inject.servlet.ServletModule;

public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		// NOTE: the servlet context will probably need changing
		serve("/infirmarium/dispatch").with(DispatchServiceServlet.class);
	}

}