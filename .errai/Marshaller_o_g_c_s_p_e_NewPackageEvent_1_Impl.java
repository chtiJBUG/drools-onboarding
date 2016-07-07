package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.project.events.NewPackageEvent;
import org.guvnor.common.services.project.model.Package;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_p_e_NewPackageEvent_1_Impl implements GeneratedMarshaller<NewPackageEvent> {
  private NewPackageEvent[] EMPTY_ARRAY = new NewPackageEvent[0];
  private Marshaller<Package> org_guvnor_common_services_project_model_Package = null;
  public NewPackageEvent[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static Package _1225228860__$1106556860_pkg(NewPackageEvent instance) /*-{
    return instance.@org.guvnor.common.services.project.events.NewPackageEvent::pkg;
  }-*/;

  private native static void _1225228860__$1106556860_pkg(NewPackageEvent instance, Package value) /*-{
    instance.@org.guvnor.common.services.project.events.NewPackageEvent::pkg = value;
  }-*/;

  public NewPackageEvent demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(NewPackageEvent.class, objId);
    }
    NewPackageEvent entity = new NewPackageEvent();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("pkg")) && (!obj.get("pkg").isNull())) {
      _1225228860__$1106556860_pkg(entity, org_guvnor_common_services_project_model_Package.demarshall(obj.get("pkg"), a1));
    }
    return entity;
  }

  public String marshall(NewPackageEvent a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.project.events.NewPackageEvent\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"pkg\":").append(org_guvnor_common_services_project_model_Package.marshall(_1225228860__$1106556860_pkg(a0), a1)).append("}").toString();
  }

  private void lazyInit() {
    if (org_guvnor_common_services_project_model_Package == null) {
      org_guvnor_common_services_project_model_Package = Marshalling.getMarshaller(Package.class);
    }
  }
}