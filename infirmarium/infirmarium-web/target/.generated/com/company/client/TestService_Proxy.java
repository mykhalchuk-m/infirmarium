package com.company.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class TestService_Proxy extends RemoteServiceProxy implements com.company.client.TestServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.company.client.TestService";
  private static final String SERIALIZATION_POLICY ="42007527894C79AA1BABCD409D82D9CA";
  private static final com.company.client.TestService_TypeSerializer SERIALIZER = new com.company.client.TestService_TypeSerializer();
  
  public TestService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public com.google.gwt.http.client.Request getCandidates(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TestService_Proxy.getCandidates", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("getCandidates");
    streamWriter.writeInt(0);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("TestService_Proxy.getCandidates", getRequestId(), "requestSerialized"));
    return doInvoke(ResponseReader.OBJECT, "TestService_Proxy.getCandidates", getRequestId(), payload, callback);
  }
  
  public com.google.gwt.http.client.Request longRunningMethod(int runningTime, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TestService_Proxy.longRunningMethod", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("longRunningMethod");
    streamWriter.writeInt(1);
    streamWriter.writeString("I");
    streamWriter.writeInt(runningTime);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("TestService_Proxy.longRunningMethod", getRequestId(), "requestSerialized"));
    return doInvoke(ResponseReader.STRING, "TestService_Proxy.longRunningMethod", getRequestId(), payload, callback);
  }
  
  public com.google.gwt.http.client.Request myMethod(java.lang.String s, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("TestService_Proxy.myMethod", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("myMethod");
    streamWriter.writeInt(1);
    streamWriter.writeString("java.lang.String");
    streamWriter.writeString(s);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("TestService_Proxy.myMethod", getRequestId(), "requestSerialized"));
    return doInvoke(ResponseReader.STRING, "TestService_Proxy.myMethod", getRequestId(), payload, callback);
  }
}
