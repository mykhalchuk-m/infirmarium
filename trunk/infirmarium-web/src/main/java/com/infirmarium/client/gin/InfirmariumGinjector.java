package com.infirmarium.client.gin;

import net.customware.gwt.dispatch.client.gin.ClientDispatchModule;

import com.google.gwt.inject.client.GinModules;
import com.infirmarium.client.core.gin.AbstractAquiliantGinjector;

@GinModules( { ClientDispatchModule.class, InfirmariumGinClientModule.class })
public interface InfirmariumGinjector extends AbstractAquiliantGinjector {

}