package com.company.client;

import com.company.client.domain.Authentication;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SecurityServiceAsync {
	public void login(String userName, AsyncCallback<String> callback);
	public void logout(AsyncCallback<String> callback);
	public void isLoggedIn(AsyncCallback<Boolean> callback);
	public void getCurrentAuthentication(AsyncCallback<Authentication> callback);

}
