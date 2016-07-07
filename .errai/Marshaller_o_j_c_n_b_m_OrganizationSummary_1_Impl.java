package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jbpm.console.ng.bd.model.OrganizationSummary;

public class Marshaller_o_j_c_n_b_m_OrganizationSummary_1_Impl implements GeneratedMarshaller<OrganizationSummary> {
  private OrganizationSummary[] EMPTY_ARRAY = new OrganizationSummary[0];
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public OrganizationSummary[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public OrganizationSummary demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(OrganizationSummary.class, objId);
    }
    OrganizationSummary entity = new OrganizationSummary();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("id")) && (!obj.get("id").isNull())) {
      entity.setId(java_lang_Long.demarshall(obj.get("id"), a1));
    }
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      entity.setName(java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("domains")) && (!obj.get("domains").isNull())) {
      a1.setAssumedElementType("org.jbpm.console.ng.bd.model.DomainSummary");
      entity.setDomains(java_util_List.demarshall(obj.get("domains"), a1));
    }
    return entity;
  }

  public String marshall(OrganizationSummary a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jbpm.console.ng.bd.model.OrganizationSummary\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"id\":").append(java_lang_Long.marshall(a0.getId(), a1)).append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"domains\":").append(java_util_List.marshall(a0.getDomains(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}