package com.infirmarium.client.core.gin;

import net.customware.gwt.dispatch.client.DefaultDispatchAsync;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.inject.client.Ginjector;
import com.infirmarium.client.internationalization.InfirmariumMessages;


public interface AbstractAquiliantGinjector extends Ginjector {

	EventBus getEventBus();

	DefaultDispatchAsync getDefaultDispatchAsync();

	InfirmariumMessages InfirmariumMessages();
}