package com.company.client.domain;

public class Candidate_FieldSerializer {
  private static native int getAge(com.company.client.domain.Candidate instance) /*-{
    return instance.@com.company.client.domain.Candidate::age;
  }-*/;
  
  private static native void  setAge(com.company.client.domain.Candidate instance, int value) /*-{
    instance.@com.company.client.domain.Candidate::age = value;
  }-*/;
  
  private static native java.lang.String getName(com.company.client.domain.Candidate instance) /*-{
    return instance.@com.company.client.domain.Candidate::name;
  }-*/;
  
  private static native void  setName(com.company.client.domain.Candidate instance, java.lang.String value) /*-{
    instance.@com.company.client.domain.Candidate::name = value;
  }-*/;
  
  public static void deserialize(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader, com.company.client.domain.Candidate instance) throws com.google.gwt.user.client.rpc.SerializationException{
    setAge(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    
  }
  
  public static native com.company.client.domain.Candidate instantiate(com.google.gwt.user.client.rpc.SerializationStreamReader streamReader) throws com.google.gwt.user.client.rpc.SerializationException/*-{
    return @com.company.client.domain.Candidate::new()();
  }-*/;
  
  public static void serialize(com.google.gwt.user.client.rpc.SerializationStreamWriter streamWriter, com.company.client.domain.Candidate instance) throws com.google.gwt.user.client.rpc.SerializationException {
    streamWriter.writeInt(getAge(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
}
