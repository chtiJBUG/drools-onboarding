package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;
import org.uberfire.ext.security.management.api.Capability;
import org.uberfire.ext.security.management.api.exception.UnsupportedServiceCapabilityException;

public class Marshaller_o_u_e_s_m_a_e_UnsupportedServiceCapabilityException_1_Impl implements GeneratedMarshaller<UnsupportedServiceCapabilityException> {
  private UnsupportedServiceCapabilityException[] EMPTY_ARRAY = new UnsupportedServiceCapabilityException[0];
  private Marshaller<Capability> org_uberfire_ext_security_management_api_Capability = null;
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Throwable> java_lang_Throwable = null;
  private Marshaller<StackTraceElement[]> arrayOf_java_lang_StackTraceElement_D1 = null;
  abstract class Marshaller_for_arrayOf_java_lang_StackTraceElement_D1 implements GeneratedMarshaller { }
  public UnsupportedServiceCapabilityException[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _1630335596__1195259493_detailMessage(Throwable instance) /*-{
    return instance.@java.lang.Throwable::detailMessage;
  }-*/;

  private native static void _1630335596__1195259493_detailMessage(Throwable instance, String value) /*-{
    instance.@java.lang.Throwable::detailMessage = value;
  }-*/;

  public UnsupportedServiceCapabilityException demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(UnsupportedServiceCapabilityException.class, objId);
    }
    final Capability c0 = obj.get("capability").isObject() != null ? Enum.valueOf(Capability.class, obj.get("capability").isObject().get("^EnumStringValue").isString().stringValue()) : obj.get("capability").isString() != null ? Enum.valueOf(Capability.class, obj.get("capability").isString().stringValue()) : null;
    UnsupportedServiceCapabilityException entity = new UnsupportedServiceCapabilityException(c0);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("detailMessage")) && (!obj.get("detailMessage").isNull())) {
      _1630335596__1195259493_detailMessage(entity, java_lang_String.demarshall(obj.get("detailMessage"), a1));
    }
    if ((obj.containsKey("cause")) && (!obj.get("cause").isNull())) {
      entity.initCause(java_lang_Throwable.demarshall(obj.get("cause"), a1));
    }
    if ((obj.containsKey("stackTrace")) && (!obj.get("stackTrace").isNull())) {
      entity.setStackTrace(arrayOf_java_lang_StackTraceElement_D1.demarshall(obj.get("stackTrace"), a1));
    }
    return entity;
  }

  public String marshall(UnsupportedServiceCapabilityException a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.uberfire.ext.security.management.api.exception.UnsupportedServiceCapabilityException\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"capability\":").append(a0.getCapability() != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.uberfire.ext.security.management.api.Capability\",\"^EnumStringValue\":\"").append(a0.getCapability().name()).append("\"}") : "null").append(",").append("\"detailMessage\":").append(java_lang_String.marshall(_1630335596__1195259493_detailMessage(a0), a1)).append(",").append("\"stackTrace\":").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\":").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_uberfire_ext_security_management_api_Capability == null) {
      org_uberfire_ext_security_management_api_Capability = Marshalling.getMarshaller(Capability.class);
    }
    if (java_lang_Throwable == null) {
      java_lang_Throwable = Marshalling.getMarshaller(Throwable.class);
    }
    if (arrayOf_java_lang_StackTraceElement_D1 == null) {
      arrayOf_java_lang_StackTraceElement_D1 = Marshalling.getMarshaller(StackTraceElement[].class, new DeferredMarshallerCreationCallback<StackTraceElement[]>() {
        public Marshaller<StackTraceElement[]> create(Class type) {
          return new QualifyingMarshallerWrapper((Marshaller) GWT.create(Marshaller_for_arrayOf_java_lang_StackTraceElement_D1.class), StackTraceElement[].class);
        }
      });
    }
  }
}