package com.infirmarium.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.infirmarium.client.SampleRemoteService;

public class SampleRemoteServiceImpl extends RemoteServiceServlet implements
		SampleRemoteService {

	public String doComplimentMe() {
		return "Hi!";
	}
}