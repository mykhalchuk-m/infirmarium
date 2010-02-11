package com.company.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class SecurityService_Proxy extends RemoteServiceProxy implements com.company.client.SecurityServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.company.client.SecurityService";
  private static final String SERIALIZATION_POLICY ="E75F407F8143F45DD2EF250BB43837BF";
  private static final com.company.client.SecurityService_TypeSerializer SERIALIZER = new com.company.client.SecurityService_TypeSerializer();
  
  public SecurityService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void getCurrentAuthentication(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.getCurrentAuthentication", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("getCurrentAuthentication");
    streamWriter.writeInt(0);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.getCurrentAuthentication", getRequestId(), "requestSerialized"));
    doInvoke(ResponseReader.OBJECT, "SecurityService_Proxy.getCurrentAuthentication", getRequestId(), payload, callback);
  }
  
  public void isLoggedIn(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.isLoggedIn", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("isLoggedIn");
    streamWriter.writeInt(0);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.isLoggedIn", getRequestId(), "requestSerialized"));
    doInvoke(ResponseReader.OBJECT, "SecurityService_Proxy.isLoggedIn", getRequestId(), payload, callback);
  }
  
  public void login(java.lang.String userName, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.login", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("login");
    streamWriter.writeInt(1);
    streamWriter.writeString("java.lang.String");
    streamWriter.writeString(userName);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.login", getRequestId(), "requestSerialized"));
    doInvoke(ResponseReader.VOID, "SecurityService_Proxy.login", getRequestId(), payload, callback);
  }
  
  public void logout(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.logout", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("logout");
    streamWriter.writeInt(0);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("SecurityService_Proxy.logout", getRequestId(), "requestSerialized"));
    doInvoke(ResponseReader.VOID, "SecurityService_Proxy.logout", getRequestId(), payload, callback);
  }
}
