package com.infirmarium.client.gin;

import net.customware.gwt.dispatch.client.DefaultDispatchAsync;
import net.customware.gwt.dispatch.client.gin.ClientDispatchModule;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.infirmarium.client.internationalization.InfirmariumMessages;

@GinModules( { ClientDispatchModule.class, InfirmariumGinClientModule.class })
public interface InfirmariumGinjector extends Ginjector {

	EventBus getEventBus();

	DefaultDispatchAsync getDefaultDispatchAsync();

	InfirmariumMessages InfirmariumMessages();
}