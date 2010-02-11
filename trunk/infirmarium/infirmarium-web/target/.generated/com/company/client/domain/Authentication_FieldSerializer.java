package com.company.client.domain;

public class Authentication_FieldSerializer {
  private static native java.lang.String getPassword(com.company.client.domain.Authentication instance) /*-{
    return instance.@com.company.client.domain.Authentication::password;
  }-*/;
  
  private static native void  setPassword(com.company.client.domain.Authentication instance, java.lang.String value) /*-{
    instance.@com.company.client.domain.Authentication::password = value;
  }-*/;
  
  private static native java.lang.String getUsername(com.company.client.domain.Authentication instance) /*-{
    return instance.@com.company.client.domain.Authentication::username;
  }-*/;
  
  private static native void  setUsername(com.company.client.domain.Authentication instance, java.lang.String value) /*-{
    instance.@com.company.client.domain.Authentication::username = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.company.client.domain.Authentication instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setPassword(instance, streamReader.readString());
    setUsername(instance, streamReader.readString());
    
  }
  
  public static native com.company.client.domain.Authentication instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.company.client.domain.Authentication::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.company.client.domain.Authentication instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeString(getUsername(instance));
    
  }
  
}
