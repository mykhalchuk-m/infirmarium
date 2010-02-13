package com.infirmarium.client.gin;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.customware.gwt.presenter.client.place.PlaceManager;

import com.google.inject.Singleton;
import com.infirmarium.client.AppPresenter;
import com.infirmarium.client.CachingDispatchAsync;
import com.infirmarium.client.components.presenters.PatientsTablePresenter;
import com.infirmarium.client.components.views.PatientsTableView;

public class InfirmariumGinClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		bind(PlaceManager.class).in(Singleton.class);

		bindPresenter(PatientsTablePresenter.class,
				PatientsTablePresenter.Display.class, PatientsTableView.class);

		bind(AppPresenter.class).in(Singleton.class);
		bind(CachingDispatchAsync.class);
	}
}