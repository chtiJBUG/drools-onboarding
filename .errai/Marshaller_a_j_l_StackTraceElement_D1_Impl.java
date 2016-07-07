package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_a_j_l_StackTraceElement_D1_Impl implements Marshaller<StackTraceElement[]> {
  private Marshaller<StackTraceElement> java_lang_StackTraceElement = null;
  private Marshaller java_lang_Object = null;
  public java.lang.StackTraceElement[][] getEmptyArray() {
    return null;
  }

  public StackTraceElement[] demarshall(EJValue a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._demarshall1(a0.isArray(), a1);
    }
  }

  private StackTraceElement[] _demarshall1(EJArray a0, MarshallingSession a1) {
    lazyInit();
    StackTraceElement[] newArray = new StackTraceElement[a0.size()];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = java_lang_StackTraceElement.demarshall(a0.get(i), a1);
    }
    return newArray;
  }

  private String _marshall1(StackTraceElement[] a0, MarshallingSession a1) {
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

  public String marshall(StackTraceElement[] a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._marshall1(a0, a1);
    }
  }

  private void lazyInit() {
    if (java_lang_StackTraceElement == null) {
      java_lang_StackTraceElement = Marshalling.getMarshaller(StackTraceElement.class);
    }
    if (java_lang_Object == null) {
      java_lang_Object = Marshalling.getMarshaller(Object.class);
    }
  }
}