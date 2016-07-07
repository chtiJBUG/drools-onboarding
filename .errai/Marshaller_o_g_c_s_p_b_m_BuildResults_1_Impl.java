package org.jboss.errai.marshalling.client.api;

import java.util.ArrayList;
import org.guvnor.common.services.project.builder.model.BuildMessage;
import org.guvnor.common.services.project.builder.model.BuildResults;
import org.guvnor.common.services.project.model.GAV;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_c_s_p_b_m_BuildResults_1_Impl implements GeneratedMarshaller<BuildResults> {
  private BuildResults[] EMPTY_ARRAY = new BuildResults[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<ArrayList> java_util_ArrayList = null;
  public BuildResults[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static GAV _951849117__$1747104294_gav(BuildResults instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.model.BuildResults::gav;
  }-*/;

  private native static void _951849117__$1747104294_gav(BuildResults instance, GAV value) /*-{
    instance.@org.guvnor.common.services.project.builder.model.BuildResults::gav = value;
  }-*/;

  private native static ArrayList _951849117__$1114099497_messages(BuildResults instance) /*-{
    return instance.@org.guvnor.common.services.project.builder.model.BuildResults::messages;
  }-*/;

  private native static void _951849117__$1114099497_messages(BuildResults instance, ArrayList<BuildMessage> value) /*-{
    instance.@org.guvnor.common.services.project.builder.model.BuildResults::messages = value;
  }-*/;

  public BuildResults demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BuildResults.class, objId);
    }
    BuildResults entity = new BuildResults();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("gav")) && (!obj.get("gav").isNull())) {
      _951849117__$1747104294_gav(entity, (GAV) ((ObjectMarshaller) java_lang_Object).demarshall(GAV.class, obj.get("gav"), a1));
    }
    if ((obj.containsKey("messages")) && (!obj.get("messages").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.builder.model.BuildMessage");
      _951849117__$1114099497_messages(entity, java_util_ArrayList.demarshall(obj.get("messages"), a1));
    }
    return entity;
  }

  public String marshall(BuildResults a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.builder.model.BuildResults\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"gav\":").append(java_lang_Object.marshall(a0.getGAV(), a1)).append(",").append("\"messages\":").append(java_util_ArrayList.marshall(_951849117__$1114099497_messages(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_ArrayList == null) {
      java_util_ArrayList = Marshalling.getMarshaller(ArrayList.class);
    }
  }
}