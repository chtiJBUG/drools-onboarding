package org.jboss.errai.marshalling.client.api;

import com.google.gwt.core.shared.GWT;
import java.util.Set;
import org.guvnor.common.services.project.model.GAV;
import org.guvnor.common.services.project.model.MavenRepositoryMetadata;
import org.guvnor.common.services.project.service.GAVAlreadyExistsException;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;
import org.jboss.errai.marshalling.client.marshallers.QualifyingMarshallerWrapper;

public class Marshaller_o_g_c_s_p_s_GAVAlreadyExistsException_1_Impl implements GeneratedMarshaller<GAVAlreadyExistsException> {
  private GAVAlreadyExistsException[] EMPTY_ARRAY = new GAVAlreadyExistsException[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Set> java_util_Set = Marshalling.getMarshaller(Set.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Throwable> java_lang_Throwable = null;
  private Marshaller<StackTraceElement[]> arrayOf_java_lang_StackTraceElement_D1 = null;
  abstract class Marshaller_for_arrayOf_java_lang_StackTraceElement_D1 implements GeneratedMarshaller { }
  public GAVAlreadyExistsException[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GAV _$606789087__$1747104294_gav(GAVAlreadyExistsException instance) /*-{
    return instance.@org.guvnor.common.services.project.service.GAVAlreadyExistsException::gav;
  }-*/;

  private native static void _$606789087__$1747104294_gav(GAVAlreadyExistsException instance, GAV value) /*-{
    instance.@org.guvnor.common.services.project.service.GAVAlreadyExistsException::gav = value;
  }-*/;

  private native static Set _$606789087__$1383343454_repositories(GAVAlreadyExistsException instance) /*-{
    return instance.@org.guvnor.common.services.project.service.GAVAlreadyExistsException::repositories;
  }-*/;

  private native static void _$606789087__$1383343454_repositories(GAVAlreadyExistsException instance, Set<MavenRepositoryMetadata> value) /*-{
    instance.@org.guvnor.common.services.project.service.GAVAlreadyExistsException::repositories = value;
  }-*/;

  private native static String _1630335596__1195259493_detailMessage(Throwable instance) /*-{
    return instance.@java.lang.Throwable::detailMessage;
  }-*/;

  private native static void _1630335596__1195259493_detailMessage(Throwable instance, String value) /*-{
    instance.@java.lang.Throwable::detailMessage = value;
  }-*/;

  public GAVAlreadyExistsException demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GAVAlreadyExistsException.class, objId);
    }
    GAVAlreadyExistsException entity = new GAVAlreadyExistsException();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("gav")) && (!obj.get("gav").isNull())) {
      _$606789087__$1747104294_gav(entity, (GAV) ((ObjectMarshaller) java_lang_Object).demarshall(GAV.class, obj.get("gav"), a1));
    }
    if ((obj.containsKey("repositories")) && (!obj.get("repositories").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.MavenRepositoryMetadata");
      _$606789087__$1383343454_repositories(entity, java_util_Set.demarshall(obj.get("repositories"), a1));
    }
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

  public String marshall(GAVAlreadyExistsException a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.service.GAVAlreadyExistsException\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"gav\":").append(java_lang_Object.marshall(a0.getGAV(), a1)).append(",").append("\"repositories\":").append(java_util_Set.marshall(a0.getRepositories(), a1)).append(",").append("\"detailMessage\":").append(java_lang_String.marshall(_1630335596__1195259493_detailMessage(a0), a1)).append(",").append("\"stackTrace\":").append(arrayOf_java_lang_StackTraceElement_D1.marshall(a0.getStackTrace(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append(",").append("\"cause\":").append(java_lang_Throwable.marshall(a0.getCause(), a1)).append("}").toString();
  }

  private void lazyInit() {
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