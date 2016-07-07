package org.jboss.errai.marshalling.client.api;

import org.guvnor.common.services.workingset.client.model.WorkingSetConfigData;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJArray;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_a_o_g_c_s_w_c_m_WorkingSetConfigData_D1_Impl implements Marshaller<WorkingSetConfigData[]> {
  private Marshaller<WorkingSetConfigData> org_guvnor_common_services_workingset_client_model_WorkingSetConfigData = null;
  private Marshaller java_lang_Object = null;
  public org.guvnor.common.services.workingset.client.model.WorkingSetConfigData[][] getEmptyArray() {
    return null;
  }

  public WorkingSetConfigData[] demarshall(EJValue a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._demarshall1(a0.isArray(), a1);
    }
  }

  private WorkingSetConfigData[] _demarshall1(EJArray a0, MarshallingSession a1) {
    lazyInit();
    WorkingSetConfigData[] newArray = new WorkingSetConfigData[a0.size()];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = org_guvnor_common_services_workingset_client_model_WorkingSetConfigData.demarshall(a0.get(i), a1);
    }
    return newArray;
  }

  private String _marshall1(WorkingSetConfigData[] a0, MarshallingSession a1) {
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

  public String marshall(WorkingSetConfigData[] a0, MarshallingSession a1) {
    if (a0 == null) {
      return null;
    } else {
      return this._marshall1(a0, a1);
    }
  }

  private void lazyInit() {
    if (org_guvnor_common_services_workingset_client_model_WorkingSetConfigData == null) {
      org_guvnor_common_services_workingset_client_model_WorkingSetConfigData = Marshalling.getMarshaller(WorkingSetConfigData.class);
    }
    if (java_lang_Object == null) {
      java_lang_Object = Marshalling.getMarshaller(Object.class);
    }
  }
}