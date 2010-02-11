package com.infirmarium.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * 
 * Make and hold a singleton (per app user) reference to service proxy. Pass
 * this to every screen
 * 
 */
public class ServiceRegistry {
	// proxies to our services

	private SampleRemoteServiceAsync sampleRemoteService;

	public SampleRemoteServiceAsync getSampleRemoteService() {
		if (sampleRemoteService == null) {
			sampleRemoteService = GWT.create(SampleRemoteService.class);
			((ServiceDefTarget) sampleRemoteService).setServiceEntryPoint(GWT
					.getModuleBaseURL()
					+ "sampleRemoteService");
		}
		return sampleRemoteService;
	}

}
