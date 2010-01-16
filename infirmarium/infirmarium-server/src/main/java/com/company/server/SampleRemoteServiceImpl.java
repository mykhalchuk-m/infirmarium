package com.company.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.company.client.SampleRemoteService;

public class SampleRemoteServiceImpl extends RemoteServiceServlet implements
		SampleRemoteService {

	public String doComplimentMe() {
		return RandomCompliment.get();
	}	
}
