package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.drools.workbench.models.testscenarios.shared.CollectionFieldData;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_CollectionFieldData_1_Impl implements GeneratedMarshaller<CollectionFieldData> {
  private CollectionFieldData[] EMPTY_ARRAY = new CollectionFieldData[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public CollectionFieldData[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public CollectionFieldData demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(CollectionFieldData.class, objId);
    }
    CollectionFieldData entity = new CollectionFieldData();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("collectionFieldList")) && (!obj.get("collectionFieldList").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.testscenarios.shared.FieldData");
      entity.setCollectionFieldList(java_util_List.demarshall(obj.get("collectionFieldList"), a1));
    }
    return entity;
  }

  public String marshall(CollectionFieldData a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.CollectionFieldData\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"collectionFieldList\":").append(java_util_List.marshall(a0.getCollectionFieldList(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}