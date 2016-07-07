package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.testscenarios.shared.FactData;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_FactData_1_Impl implements GeneratedMarshaller<FactData> {
  private FactData[] EMPTY_ARRAY = new FactData[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public FactData[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static boolean _271242044__64711720_isModify(FactData instance) /*-{
    return instance.@org.drools.workbench.models.testscenarios.shared.FactData::isModify;
  }-*/;

  private native static void _271242044__64711720_isModify(FactData instance, boolean value) /*-{
    instance.@org.drools.workbench.models.testscenarios.shared.FactData::isModify = value;
  }-*/;

  public FactData demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(FactData.class, objId);
    }
    FactData entity = new FactData();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("isModify")) && (!obj.get("isModify").isNull())) {
      _271242044__64711720_isModify(entity, java_lang_Boolean.demarshall(obj.get("isModify"), a1));
    }
    if ((obj.containsKey("type")) && (!obj.get("type").isNull())) {
      entity.setType(java_lang_String.demarshall(obj.get("type"), a1));
    }
    if ((obj.containsKey("fieldData")) && (!obj.get("fieldData").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.testscenarios.shared.Field");
      entity.setFieldData(java_util_List.demarshall(obj.get("fieldData"), a1));
    }
    return entity;
  }

  public String marshall(FactData a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.FactData\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"isModify\":").append(java_lang_Boolean.marshall(_271242044__64711720_isModify(a0), a1)).append(",").append("\"type\":").append(java_lang_String.marshall(a0.getType(), a1)).append(",").append("\"fieldData\":").append(java_util_List.marshall(a0.getFieldData(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}