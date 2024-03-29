package com.infirmarium.client.gin;

import net.customware.gwt.dispatch.client.DefaultDispatchAsync;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.infirmarium.client.components.elements.RootWidget;

public class InfirmariumGinClientModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(DefaultDispatchAsync.class).in(Singleton.class);
		bind(RootWidget.class).in(Singleton.class);
	}

	@Provides
	@Singleton
	HandlerManager provideHandlerManager() {
		return new HandlerManager(null);
	}
}