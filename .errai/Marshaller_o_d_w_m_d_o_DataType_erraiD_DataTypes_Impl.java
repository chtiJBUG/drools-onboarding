package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.oracle.DataType.DataTypes;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_w_m_d_o_DataType_erraiD_DataTypes_Impl implements GeneratedMarshaller<DataTypes> {
  private DataTypes[] EMPTY_ARRAY = new DataTypes[0];
  public DataTypes[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataTypes demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    DataTypes entity = obj != null ? Enum.valueOf(DataTypes.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(DataTypes.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(DataTypes a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.drools.workbench.models.datamodel.oracle.DataType$DataTypes\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}