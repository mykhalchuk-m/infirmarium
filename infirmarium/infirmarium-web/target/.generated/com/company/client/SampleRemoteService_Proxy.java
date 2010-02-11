package com.company.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;

public class SampleRemoteService_Proxy extends RemoteServiceProxy implements com.company.client.SampleRemoteServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.company.client.SampleRemoteService";
  private static final String SERIALIZATION_POLICY ="29F4EA1240F157649C12466F01F46F60";
  private static final com.company.client.SampleRemoteService_TypeSerializer SERIALIZER = new com.company.client.SampleRemoteService_TypeSerializer();
  
  public SampleRemoteService_Proxy() {
    super(GWT.getModuleBaseURL(),
      null, 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void doComplimentMe(com.google.gwt.user.client.rpc.AsyncCallback callback) {
    int requestId = getNextRequestId();
    boolean toss = isStatsAvailable() && stats(timeStat("SampleRemoteService_Proxy.doComplimentMe", getRequestId(), "begin"));
    ClientSerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
    streamWriter.writeString("doComplimentMe");
    streamWriter.writeInt(0);
    String payload = streamWriter.toString();
    toss = isStatsAvailable() && stats(timeStat("SampleRemoteService_Proxy.doComplimentMe", getRequestId(), "requestSerialized"));
    doInvoke(ResponseReader.STRING, "SampleRemoteService_Proxy.doComplimentMe", getRequestId(), payload, callback);
  }
}
