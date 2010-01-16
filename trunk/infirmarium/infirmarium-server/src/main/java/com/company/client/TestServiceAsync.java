package com.company.client;

import java.util.ArrayList;

import com.company.client.domain.Candidate;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TestServiceAsync {
	public Request myMethod(String s, AsyncCallback<String> callback);
	public Request getCandidates(AsyncCallback<ArrayList<Candidate>> callback);
	public Request longRunningMethod(int runningTime, AsyncCallback<String> callback);
}
