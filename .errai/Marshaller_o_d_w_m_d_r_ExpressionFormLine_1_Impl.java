package org.jboss.errai.marshalling.client.api;

import java.util.LinkedList;
import org.drools.workbench.models.datamodel.rule.ExpressionFormLine;
import org.drools.workbench.models.datamodel.rule.ExpressionPart;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_r_ExpressionFormLine_1_Impl implements GeneratedMarshaller<ExpressionFormLine> {
  private ExpressionFormLine[] EMPTY_ARRAY = new ExpressionFormLine[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<LinkedList> java_util_LinkedList = Marshalling.getMarshaller(LinkedList.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  public ExpressionFormLine[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static LinkedList _525466253__$1899270121_parts(ExpressionFormLine instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionFormLine::parts;
  }-*/;

  private native static void _525466253__$1899270121_parts(ExpressionFormLine instance, LinkedList<ExpressionPart> value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionFormLine::parts = value;
  }-*/;

  private native static int _525466253__104431_index(ExpressionFormLine instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.ExpressionFormLine::index;
  }-*/;

  private native static void _525466253__104431_index(ExpressionFormLine instance, int value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.ExpressionFormLine::index = value;
  }-*/;

  public ExpressionFormLine demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(ExpressionFormLine.class, objId);
    }
    ExpressionFormLine entity = new ExpressionFormLine();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("binding")) && (!obj.get("binding").isNull())) {
      entity.setBinding(java_lang_String.demarshall(obj.get("binding"), a1));
    }
    if ((obj.containsKey("parts")) && (!obj.get("parts").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.rule.ExpressionPart");
      _525466253__$1899270121_parts(entity, java_util_LinkedList.demarshall(obj.get("parts"), a1));
    }
    if ((obj.containsKey("index")) && (!obj.get("index").isNull())) {
      _525466253__104431_index(entity, java_lang_Integer.demarshall(obj.get("index"), a1));
    }
    return entity;
  }

  public String marshall(ExpressionFormLine a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.ExpressionFormLine\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"binding\":").append(java_lang_String.marshall(a0.getBinding(), a1)).append(",").append("\"parts\":").append(java_util_LinkedList.marshall(_525466253__$1899270121_parts(a0), a1)).append(",").append("\"index\":").append(java_lang_Integer.marshall(a0.getIndex(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}