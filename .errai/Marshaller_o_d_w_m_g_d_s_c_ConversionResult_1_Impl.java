package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset;
import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage;
import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionResult;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_g_d_s_c_ConversionResult_1_Impl implements GeneratedMarshaller<ConversionResult> {
  private ConversionResult[] EMPTY_ARRAY = new ConversionResult[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public ConversionResult[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _$1763901786__65821278_newAssets(ConversionResult instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionResult::newAssets;
  }-*/;

  private native static void _$1763901786__65821278_newAssets(ConversionResult instance, List<ConversionAsset> value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionResult::newAssets = value;
  }-*/;

  private native static List _$1763901786__65821278_messages(ConversionResult instance) /*-{
    return instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionResult::messages;
  }-*/;

  private native static void _$1763901786__65821278_messages(ConversionResult instance, List<ConversionMessage> value) /*-{
    instance.@org.drools.workbench.models.guided.dtable.shared.conversion.ConversionResult::messages = value;
  }-*/;

  public ConversionResult demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ConversionResult.class, objId);
    }
    ConversionResult entity = new ConversionResult();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("newAssets")) && (!obj.get("newAssets").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtable.shared.conversion.ConversionAsset");
      _$1763901786__65821278_newAssets(entity, java_util_List.demarshall(obj.get("newAssets"), a1));
    }
    if ((obj.containsKey("messages")) && (!obj.get("messages").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.guided.dtable.shared.conversion.ConversionMessage");
      _$1763901786__65821278_messages(entity, java_util_List.demarshall(obj.get("messages"), a1));
    }
    return entity;
  }

  public String marshall(ConversionResult a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.guided.dtable.shared.conversion.ConversionResult\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"newAssets\":").append(java_util_List.marshall(a0.getNewAssets(), a1)).append(",").append("\"messages\":").append(java_util_List.marshall(a0.getMessages(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}