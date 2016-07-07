package org.jboss.errai.marshalling.client.api;

import org.dashbuilder.dataprovider.DataSetProviderType;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_d_d_DataSetProviderType_1_Impl implements GeneratedMarshaller<DataSetProviderType> {
  private DataSetProviderType[] EMPTY_ARRAY = new DataSetProviderType[0];
  public DataSetProviderType[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  public DataSetProviderType demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    DataSetProviderType entity = obj != null ? Enum.valueOf(DataSetProviderType.class, obj.get("^EnumStringValue").isString().stringValue()) : a0.isString() != null ? Enum.valueOf(DataSetProviderType.class, a0.isString().stringValue()) : null;
    return entity;
  }

  public String marshall(DataSetProviderType a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final StringBuilder json = new StringBuilder();
    return json.append(a0 != null ? new StringBuilder(64).append("{\"^EncodedType\":\"org.dashbuilder.dataprovider.DataSetProviderType\",\"^EnumStringValue\":\"").append(a0.name()).append("\"}") : "null").toString();
  }

  private void lazyInit() {

  }
}