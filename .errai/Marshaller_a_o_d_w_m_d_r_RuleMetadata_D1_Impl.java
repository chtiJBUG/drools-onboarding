package org.jboss.errai.marshalling.client.api;

import org.drools.workbench.models.datamodel.rule.RuleMetadata;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_a_o_d_w_m_d_r_RuleMetadata_D1_Impl implements Marshaller<RuleMetadata[]> {
  private Marshaller<RuleMetadata> org_drools_workbench_models_datamodel_rule_RuleMetadata = null;
  private Marshaller java_lang_Object = null;
  public org.drools.workbench.models.datamodel.rule.RuleMetadata[][] getEmptyArray() {
    return null;
  }

  public RuleMetadata[] demarshall(EJValue a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._demarshall1(a0.isArray(), a1);
    }
  }

  private RuleMetadata[] _demarshall1(EJArray a0, MarshallingSession a1) {
    lazyInit();
    RuleMetadata[] newArray = new RuleMetadata[a0.size()];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = org_drools_workbench_models_datamodel_rule_RuleMetadata.demarshall(a0.get(i), a1);
    }
    return newArray;
  }

  private String _marshall1(RuleMetadata[] a0, MarshallingSession a1) {
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

  public String marshall(RuleMetadata[] a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._marshall1(a0, a1);
    }
  }

  private void lazyInit() {
    if (org_drools_workbench_models_datamodel_rule_RuleMetadata == null) {
      org_drools_workbench_models_datamodel_rule_RuleMetadata = Marshalling.getMarshaller(RuleMetadata.class);
    }
    if (java_lang_Object == null) {
      java_lang_Object = Marshalling.getMarshaller(Object.class);
    }
  }
}