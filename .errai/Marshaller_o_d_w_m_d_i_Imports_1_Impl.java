package org.jboss.errai.marshalling.client.api;

import java.util.ArrayList;
import org.drools.workbench.models.datamodel.imports.Import;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_i_Imports_1_Impl implements GeneratedMarshaller<Imports> {
  private Imports[] EMPTY_ARRAY = new Imports[0];
  private Marshaller<ArrayList> java_util_ArrayList = null;
  public Imports[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static ArrayList _$1648285575__$1114099497_imports(Imports instance) /*-{
    return instance.@org.drools.workbench.models.datamodel.imports.Imports::imports;
  }-*/;

  private native static void _$1648285575__$1114099497_imports(Imports instance, ArrayList<Import> value) /*-{
    instance.@org.drools.workbench.models.datamodel.imports.Imports::imports = value;
  }-*/;

  public Imports demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(Imports.class, objId);
    }
    Imports entity = new Imports();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("imports")) && (!obj.get("imports").isNull())) {
      a1.setAssumedElementType("org.drools.workbench.models.datamodel.imports.Import");
      _$1648285575__$1114099497_imports(entity, java_util_ArrayList.demarshall(obj.get("imports"), a1));
    }
    return entity;
  }

  public String marshall(Imports a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.imports.Imports\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"imports\":").append(java_util_ArrayList.marshall(_$1648285575__$1114099497_imports(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (java_util_ArrayList == null) {
      java_util_ArrayList = Marshalling.getMarshaller(ArrayList.class);
    }
  }
}