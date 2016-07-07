package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.common.services.project.model.Dependencies;
import org.guvnor.common.services.project.model.Dependency;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_m_Dependencies_1_Impl implements GeneratedMarshaller<Dependencies> {
  private Dependencies[] EMPTY_ARRAY = new Dependencies[0];
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public Dependencies[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static List _891533291__65821278_dependencies(Dependencies instance) /*-{
    return instance.@org.guvnor.common.services.project.model.Dependencies::dependencies;
  }-*/;

  private native static void _891533291__65821278_dependencies(Dependencies instance, List<Dependency> value) /*-{
    instance.@org.guvnor.common.services.project.model.Dependencies::dependencies = value;
  }-*/;

  public Dependencies demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Dependencies.class, objId);
    }
    Dependencies entity = new Dependencies();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("dependencies")) && (!obj.get("dependencies").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.project.model.Dependency");
      _891533291__65821278_dependencies(entity, java_util_List.demarshall(obj.get("dependencies"), a1));
    }
    return entity;
  }

  public String marshall(Dependencies a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.model.Dependencies\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"dependencies\":").append(java_util_List.marshall(_891533291__65821278_dependencies(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}