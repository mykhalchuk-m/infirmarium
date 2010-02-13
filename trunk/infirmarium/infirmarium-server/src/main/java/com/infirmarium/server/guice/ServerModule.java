package com.infirmarium.server.guice;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import org.apache.commons.logging.Log;

import com.google.inject.Singleton;
import com.infirmarium.server.commandhandlers.GetPersonsHandler;

/**
 * Module which binds the handlers and configurations
 * 
 */
public class ServerModule extends ActionHandlerModule {

	@Override
	protected void configureHandlers() {
		bindHandler(GetPersonsHandler.class);

		bind(Log.class).toProvider(LogProvider.class).in(Singleton.class);
	}
}