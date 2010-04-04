package com.infirmarium.client.gin;

import net.customware.gwt.dispatch.client.DefaultDispatchAsync;
import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.infirmarium.client.internationalization.InfirmariumMessages;

public class InfirmariumGinClientModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		bind(DefaultDispatchAsync.class).in(Singleton.class);
		bind(InfirmariumMessages.class).in(Singleton.class);
	}
}