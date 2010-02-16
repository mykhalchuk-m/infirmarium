package com.infirmarium.client.gin;

import net.customware.gwt.dispatch.client.gin.ClientDispatchModule;
import net.customware.gwt.presenter.client.place.PlaceManager;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.infirmarium.client.AppPresenter;

@GinModules( { ClientDispatchModule.class, InfirmariumGinClientModule.class })
public interface InfirmariumGinjector extends Ginjector {

	AppPresenter getAppPresenter();

	PlaceManager getPlaceManager();

}