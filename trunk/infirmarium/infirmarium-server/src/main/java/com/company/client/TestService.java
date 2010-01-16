package com.company.client;

import java.util.ArrayList;

import com.company.client.domain.Candidate;
import com.google.gwt.user.client.rpc.RemoteService;

public interface TestService extends RemoteService {
	public String myMethod(String s);
	public ArrayList<Candidate> getCandidates();
	public String longRunningMethod(int runningTime);
}