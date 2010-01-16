package com.company.client;

import com.company.client.domain.Options;

/**
 * 
 * Like the session in traditional webapps.  
 * In GWT apps client state is managed on the client
 * 
 */
public class ClientState {
	private String userName;
	private Options userOptions;
	
	public void setUserName(String username) {
		this.userName=username;
	}

	public String getUserName() {
		return userName;
	}
	
}
