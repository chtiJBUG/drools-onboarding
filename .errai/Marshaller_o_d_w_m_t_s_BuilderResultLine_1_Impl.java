package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.testscenarios.shared.BuilderResultLine;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_t_s_BuilderResultLine_1_Impl implements GeneratedMarshaller<BuilderResultLine> {
  private BuilderResultLine[] EMPTY_ARRAY = new BuilderResultLine[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public BuilderResultLine[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public BuilderResultLine demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(BuilderResultLine.class, objId);
    }
    BuilderResultLine entity = new BuilderResultLine();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("assetFormat")) && (!obj.get("assetFormat").isNull())) {
      entity.setAssetFormat(java_lang_String.demarshall(obj.get("assetFormat"), a1));
    }
    if ((obj.containsKey("assetName")) && (!obj.get("assetName").isNull())) {
      entity.setAssetName(java_lang_String.demarshall(obj.get("assetName"), a1));
    }
    if ((obj.containsKey("uuid")) && (!obj.get("uuid").isNull())) {
      entity.setUuid(java_lang_String.demarshall(obj.get("uuid"), a1));
    }
    if ((obj.containsKey("message")) && (!obj.get("message").isNull())) {
      entity.setMessage(java_lang_String.demarshall(obj.get("message"), a1));
    }
    return entity;
  }

  public String marshall(BuilderResultLine a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.testscenarios.shared.BuilderResultLine\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"assetFormat\":").append(java_lang_String.marshall(a0.getAssetFormat(), a1)).append(",").append("\"assetName\":").append(java_lang_String.marshall(a0.getAssetName(), a1)).append(",").append("\"uuid\":").append(java_lang_String.marshall(a0.getUuid(), a1)).append(",").append("\"message\":").append(java_lang_String.marshall(a0.getMessage(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}