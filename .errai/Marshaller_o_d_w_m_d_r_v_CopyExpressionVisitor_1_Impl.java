package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.ExpressionPart;
import org.drools.workbench.models.datamodel.rule.visitors.CopyExpressionVisitor;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_d_w_m_d_r_v_CopyExpressionVisitor_1_Impl implements GeneratedMarshaller<CopyExpressionVisitor> {
  private CopyExpressionVisitor[] EMPTY_ARRAY = new CopyExpressionVisitor[0];
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  public CopyExpressionVisitor[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ExpressionPart _$1773955691__1493848616_root(CopyExpressionVisitor instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.visitors.CopyExpressionVisitor::root;
  }-*/;

  private native static void _$1773955691__1493848616_root(CopyExpressionVisitor instance, ExpressionPart value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.visitors.CopyExpressionVisitor::root = value;
  }-*/;

  private native static ExpressionPart _$1773955691__1493848616_curr(CopyExpressionVisitor instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.rule.visitors.CopyExpressionVisitor::curr;
  }-*/;

  private native static void _$1773955691__1493848616_curr(CopyExpressionVisitor instance, ExpressionPart value) /*-{
    instance.@org.drools.workbench.models.datamodel.rule.visitors.CopyExpressionVisitor::curr = value;
  }-*/;

  public CopyExpressionVisitor demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CopyExpressionVisitor.class, objId);
    }
    CopyExpressionVisitor entity = new CopyExpressionVisitor();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("root")) && (!obj.get("root").isNull())) {
      _$1773955691__1493848616_root(entity, (ExpressionPart) ((ObjectMarshaller) java_lang_Object).demarshall(ExpressionPart.class, obj.get("root"), a1));
    }
    if ((obj.containsKey("curr")) && (!obj.get("curr").isNull())) {
      _$1773955691__1493848616_curr(entity, (ExpressionPart) ((ObjectMarshaller) java_lang_Object).demarshall(ExpressionPart.class, obj.get("curr"), a1));
    }
    return entity;
  }

  public String marshall(CopyExpressionVisitor a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.rule.visitors.CopyExpressionVisitor\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"root\":").append(java_lang_Object.marshall(_$1773955691__1493848616_root(a0), a1)).append(",").append("\"curr\":").append(java_lang_Object.marshall(_$1773955691__1493848616_curr(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}