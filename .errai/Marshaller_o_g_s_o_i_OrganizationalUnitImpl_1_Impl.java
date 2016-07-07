package org.jboss.errai.marshalling.client.api;

import java.util.Collection;
import org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl;
import org.guvnor.structure.repositories.Repository;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.marshalling.client.marshallers.ObjectMarshaller;

public class Marshaller_o_g_s_o_i_OrganizationalUnitImpl_1_Impl implements GeneratedMarshaller<OrganizationalUnitImpl> {
  private OrganizationalUnitImpl[] EMPTY_ARRAY = new OrganizationalUnitImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller java_lang_Object = Marshalling.getMarshaller(Object.class);
  private Marshaller<Boolean> java_lang_Boolean = Marshalling.getMarshaller(Boolean.class);
  public OrganizationalUnitImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$911052806__1195259493_name(OrganizationalUnitImpl instance) /*-{
    return instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::name;
  }-*/;

  private native static void _$911052806__1195259493_name(OrganizationalUnitImpl instance, String value) /*-{
    instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::name = value;
  }-*/;

  private native static String _$911052806__1195259493_defaultGroupId(OrganizationalUnitImpl instance) /*-{
    return instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::defaultGroupId;
  }-*/;

  private native static void _$911052806__1195259493_defaultGroupId(OrganizationalUnitImpl instance, String value) /*-{
    instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::defaultGroupId = value;
  }-*/;

  private native static String _$911052806__1195259493_owner(OrganizationalUnitImpl instance) /*-{
    return instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::owner;
  }-*/;

  private native static void _$911052806__1195259493_owner(OrganizationalUnitImpl instance, String value) /*-{
    instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::owner = value;
  }-*/;

  private native static Collection _$911052806__$688322466_repositories(OrganizationalUnitImpl instance) /*-{
    return instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::repositories;
  }-*/;

  private native static void _$911052806__$688322466_repositories(OrganizationalUnitImpl instance, Collection<Repository> value) /*-{
    instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::repositories = value;
  }-*/;

  private native static Collection _$911052806__$688322466_groups(OrganizationalUnitImpl instance) /*-{
    return instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::groups;
  }-*/;

  private native static void _$911052806__$688322466_groups(OrganizationalUnitImpl instance, Collection<String> value) /*-{
    instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::groups = value;
  }-*/;

  private native static boolean _$911052806__64711720_requiresRefresh(OrganizationalUnitImpl instance) /*-{
    return instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::requiresRefresh;
  }-*/;

  private native static void _$911052806__64711720_requiresRefresh(OrganizationalUnitImpl instance, boolean value) /*-{
    instance.@org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl::requiresRefresh = value;
  }-*/;

  public OrganizationalUnitImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(OrganizationalUnitImpl.class, objId);
    }
    OrganizationalUnitImpl entity = new OrganizationalUnitImpl();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$911052806__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    if ((obj.containsKey("defaultGroupId")) && (!obj.get("defaultGroupId").isNull())) {
      _$911052806__1195259493_defaultGroupId(entity, java_lang_String.demarshall(obj.get("defaultGroupId"), a1));
    }
    if ((obj.containsKey("owner")) && (!obj.get("owner").isNull())) {
      _$911052806__1195259493_owner(entity, java_lang_String.demarshall(obj.get("owner"), a1));
    }
    if ((obj.containsKey("repositories")) && (!obj.get("repositories").isNull())) {
      _$911052806__$688322466_repositories(entity, (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("repositories"), a1));
    }
    if ((obj.containsKey("groups")) && (!obj.get("groups").isNull())) {
      _$911052806__$688322466_groups(entity, (Collection) ((ObjectMarshaller) java_lang_Object).demarshall(Collection.class, obj.get("groups"), a1));
    }
    if ((obj.containsKey("requiresRefresh")) && (!obj.get("requiresRefresh").isNull())) {
      _$911052806__64711720_requiresRefresh(entity, java_lang_Boolean.demarshall(obj.get("requiresRefresh"), a1));
    }
    return entity;
  }

  public String marshall(OrganizationalUnitImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.structure.organizationalunit.impl.OrganizationalUnitImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append(",").append("\"defaultGroupId\":").append(java_lang_String.marshall(a0.getDefaultGroupId(), a1)).append(",").append("\"owner\":").append(java_lang_String.marshall(a0.getOwner(), a1)).append(",").append("\"repositories\":").append(java_lang_Object.marshall(a0.getRepositories(), a1)).append(",").append("\"groups\":").append(java_lang_Object.marshall(a0.getGroups(), a1)).append(",").append("\"requiresRefresh\":").append(java_lang_Boolean.marshall(_$911052806__64711720_requiresRefresh(a0), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}