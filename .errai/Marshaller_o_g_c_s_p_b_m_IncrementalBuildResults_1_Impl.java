package org.jboss.errai.marshalling.client.api;

import java.util.ArrayList;
import org.guvnor.common.services.project.builder.model.BuildMessage;
import org.guvnor.common.services.project.builder.model.IncrementalBuildResults;
import org.guvnor.common.services.project.model.GAV;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_c_s_p_b_m_IncrementalBuildResults_1_Impl implements GeneratedMarshaller<IncrementalBuildResults> {
  private IncrementalBuildResults[] EMPTY_ARRAY = new IncrementalBuildResults[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<ArrayList> java_util_ArrayList = null;
  public IncrementalBuildResults[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GAV _$1312164723__$1747104294_gav(IncrementalBuildResults instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.model.IncrementalBuildResults::gav;
  }-*/;

  private native static void _$1312164723__$1747104294_gav(IncrementalBuildResults instance, GAV value) /*-{
    instance.@org.guvnor.common.services.project.builder.model.IncrementalBuildResults::gav = value;
  }-*/;

  private native static ArrayList _$1312164723__$1114099497_addedMessages(IncrementalBuildResults instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.model.IncrementalBuildResults::addedMessages;
  }-*/;

  private native static void _$1312164723__$1114099497_addedMessages(IncrementalBuildResults instance, ArrayList<BuildMessage> value) /*-{
    instance.@org.guvnor.common.services.project.builder.model.IncrementalBuildResults::addedMessages = value;
  }-*/;

  private native static ArrayList _$1312164723__$1114099497_removedMessages(IncrementalBuildResults instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.model.IncrementalBuildResults::removedMessages;
  }-*/;

  private native static void _$1312164723__$1114099497_removedMessages(IncrementalBuildResults instance, ArrayList<BuildMessage> value) /*-{
    instance.@org.guvnor.common.services.project.builder.model.IncrementalBuildResults::removedMessages = value;
  }-*/;

  public IncrementalBuildResults demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(IncrementalBuildResults.class, objId);
    }
    IncrementalBuildResults entity = new IncrementalBuildResults();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("gav")) && (!obj.get("gav").isNull())) {
      _$1312164723__$1747104294_gav(entity, (GAV) ((ObjectMarshaller) java_lang_Object).demarshall(GAV.class, obj.get("gav"), a1));
    }
    if ((obj.containsKey("addedMessages")) && (!obj.get("addedMessages").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.builder.model.BuildMessage");
      _$1312164723__$1114099497_addedMessages(entity, java_util_ArrayList.demarshall(obj.get("addedMessages"), a1));
    }
    if ((obj.containsKey("removedMessages")) && (!obj.get("removedMessages").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.builder.model.BuildMessage");
      _$1312164723__$1114099497_removedMessages(entity, java_util_ArrayList.demarshall(obj.get("removedMessages"), a1));
    }
    return entity;
  }

  public String marshall(IncrementalBuildResults a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.builder.model.IncrementalBuildResults\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"gav\":").append(java_lang_Object.marshall(a0.getGAV(), a1)).append(",").append("\"addedMessages\":").append(java_util_ArrayList.marshall(_$1312164723__$1114099497_addedMessages(a0), a1)).append(",").append("\"removedMessages\":").append(java_util_ArrayList.marshall(_$1312164723__$1114099497_removedMessages(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_ArrayList == null) {
      java_util_ArrayList = Marshalling.getMarshaller(ArrayList.class);
    }
  }
}