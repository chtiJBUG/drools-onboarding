package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.IPattern;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_a_o_d_w_m_d_r_IPattern_D1_Impl implements Marshaller<IPattern[]> {
  private Marshaller java_lang_Object = null;
  public org.drools.workbench.models.datamodel.rule.IPattern[][] getEmptyArray() {
    return null;
  }

  public IPattern[] demarshall(EJValue a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._demarshall1(a0.isArray(), a1);
    }
  }

  private IPattern[] _demarshall1(EJArray a0, MarshallingSession a1) {
    lazyInit();
    IPattern[] newArray = new IPattern[a0.size()];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = (IPattern) java_lang_Object.demarshall(a0.get(i), a1);
    }
    return newArray;
  }

  private String _marshall1(IPattern[] a0, MarshallingSession a1) {
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

  public String marshall(IPattern[] a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._marshall1(a0, a1);
    }
  }

  private void lazyInit() {
    if (java_lang_Object == null) {
      java_lang_Object = Marshalling.getMarshaller(Object.class);
    }
  }
}