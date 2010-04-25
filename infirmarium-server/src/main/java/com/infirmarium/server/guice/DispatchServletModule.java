package com.infirmarium.server.guice;

import com.google.inject.servlet.ServletModule;
import com.infirmarium.gwt.dispatch.server.service.DispatchServiceServlet;

public class DispatchServletModule extends ServletModule {

	@Override
	public void configureServlets() {
		// NOTE: the servlet context will probably need changing
		serve("/infirmarium/dispatch").with(DispatchServiceServlet.class);
	}

}