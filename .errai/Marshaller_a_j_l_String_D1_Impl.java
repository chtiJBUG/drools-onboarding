package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_a_j_l_String_D1_Impl implements Marshaller<String[]> {
  private Marshaller<String> java_lang_String = null;
  private Marshaller java_lang_Object = null;
  public java.lang.String[][] getEmptyArray() {
    return null;
  }

  public String[] demarshall(EJValue a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._demarshall1(a0.isArray(), a1);
    }
  }

  private String[] _demarshall1(EJArray a0, MarshallingSession a1) {
    lazyInit();
    String[] newArray = new String[a0.size()];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = java_lang_String.demarshall(a0.get(i), a1);
    }
    return newArray;
  }

  private String _marshall1(String[] a0, MarshallingSession a1) {
    lazyInit();
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < a0.length; i++) {
      if (i > 0) {
        sb.append(",");
      }
      sb.append(java_lang_Object.marshall(a0[i], a1));
    }
    return sb.append("]").toString();
  }

  public String marshall(String[] a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._marshall1(a0, a1);
    }
  }

  private void lazyInit() {
    if (java_lang_String == null) {
      java_lang_String = Marshalling.getMarshaller(String.class);
    }
    if (java_lang_Object == null) {
      java_lang_Object = Marshalling.getMarshaller(Object.class);
    }
  }
}