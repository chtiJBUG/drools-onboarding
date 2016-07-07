package org.jboss.errai.databinding.client;

import org.jboss.errai.databinding.client.api.InitialState;
import org.jboss.errai.ui.shared.api.Locale;
import org.jbpm.designer.client.shared.AssignmentRow;
import org.jbpm.designer.client.shared.Variable.VariableType;

public class BindableProxyLoaderImpl implements BindableProxyLoader { public void loadBindableProxies() {
    class org_jbpm_designer_client_shared_AssignmentRowProxy extends AssignmentRow implements BindableProxy {
      private BindableProxyAgent<AssignmentRow> agent;
      public org_jbpm_designer_client_shared_AssignmentRowProxy(InitialState initialState) {
        this(new AssignmentRow(), initialState);
      }

      public org_jbpm_designer_client_shared_AssignmentRowProxy(AssignmentRow target, InitialState initialState) {
        agent = new BindableProxyAgent<AssignmentRow>(this, target, initialState);
        agent.propertyTypes.put("variableType", new PropertyType(VariableType.class, false, false));
        agent.propertyTypes.put("id", new PropertyType(Long.class, false, false));
        agent.propertyTypes.put("dataType", new PropertyType(String.class, false, false));
        agent.propertyTypes.put("constant", new PropertyType(String.class, false, false));
        agent.propertyTypes.put("customDataType", new PropertyType(String.class, false, false));
        agent.propertyTypes.put("complete", new PropertyType(Boolean.class, false, false));
        agent.propertyTypes.put("name", new PropertyType(String.class, false, false));
        agent.propertyTypes.put("processVar", new PropertyType(String.class, false, false));
        agent.copyValues();
      }

      public BindableProxyAgent getBindableProxyAgent() {
        return agent;
      }

      public void updateWidgets() {
        agent.updateWidgetsAndFireEvents();
      }

      public AssignmentRow unwrap() {
        return agent.target;
      }

      public AssignmentRow deepUnwrap() {
        final AssignmentRow clone = new AssignmentRow();
        clone.setVariableType(agent.target.getVariableType());
        clone.setId(agent.target.getId());
        clone.setDataType(agent.target.getDataType());
        clone.setConstant(agent.target.getConstant());
        clone.setCustomDataType(agent.target.getCustomDataType());
        clone.setName(agent.target.getName());
        clone.setProcessVar(agent.target.getProcessVar());
        return clone;
      }

      public boolean equals(Object obj) {
        if (obj instanceof org_jbpm_designer_client_shared_AssignmentRowProxy) {
          obj = ((org_jbpm_designer_client_shared_AssignmentRowProxy) obj).unwrap();
        }
        return agent.target.equals(obj);
      }

      public int hashCode() {
        return agent.target.hashCode();
      }

      public String toString() {
        return agent.target.toString();
      }

      public VariableType getVariableType() {
        return agent.target.getVariableType();
      }

      public void setVariableType(VariableType variableType) {
        VariableType oldValue = agent.target.getVariableType();
        agent.target.setVariableType(variableType);
        agent.updateWidgetsAndFireEvent("variableType", oldValue, variableType);
      }

      public long getId() {
        return agent.target.getId();
      }

      public void setId(long id) {
        long oldValue = agent.target.getId();
        agent.target.setId(id);
        agent.updateWidgetsAndFireEvent("id", oldValue, id);
      }

      public String getDataType() {
        return agent.target.getDataType();
      }

      public void setDataType(String dataType) {
        String oldValue = agent.target.getDataType();
        agent.target.setDataType(dataType);
        agent.updateWidgetsAndFireEvent("dataType", oldValue, dataType);
      }

      public String getConstant() {
        return agent.target.getConstant();
      }

      public void setConstant(String constant) {
        String oldValue = agent.target.getConstant();
        agent.target.setConstant(constant);
        agent.updateWidgetsAndFireEvent("constant", oldValue, constant);
      }

      public String getCustomDataType() {
        return agent.target.getCustomDataType();
      }

      public void setCustomDataType(String customDataType) {
        String oldValue = agent.target.getCustomDataType();
        agent.target.setCustomDataType(customDataType);
        agent.updateWidgetsAndFireEvent("customDataType", oldValue, customDataType);
      }

      public boolean isComplete() {
        return agent.target.isComplete();
      }

      public String getName() {
        return agent.target.getName();
      }

      public void setName(String name) {
        String oldValue = agent.target.getName();
        agent.target.setName(name);
        agent.updateWidgetsAndFireEvent("name", oldValue, name);
      }

      public String getProcessVar() {
        return agent.target.getProcessVar();
      }

      public void setProcessVar(String processVar) {
        String oldValue = agent.target.getProcessVar();
        agent.target.setProcessVar(processVar);
        agent.updateWidgetsAndFireEvent("processVar", oldValue, processVar);
      }

      public Object get(String property) {
        if (property.equals("variableType")) {
          return getVariableType();
        }
        if (property.equals("id")) {
          return getId();
        }
        if (property.equals("dataType")) {
          return getDataType();
        }
        if (property.equals("constant")) {
          return getConstant();
        }
        if (property.equals("customDataType")) {
          return getCustomDataType();
        }
        if (property.equals("complete")) {
          return isComplete();
        }
        if (property.equals("name")) {
          return getName();
        }
        if (property.equals("processVar")) {
          return getProcessVar();
        }
        throw new NonExistingPropertyException(property);
      }

      public void set(String property, Object value) {
        if (property.equals("variableType")) {
          agent.target.setVariableType((VariableType) value);
          return;
        }
        if (property.equals("id")) {
          agent.target.setId((Long) value);
          return;
        }
        if (property.equals("dataType")) {
          agent.target.setDataType((String) value);
          return;
        }
        if (property.equals("constant")) {
          agent.target.setConstant((String) value);
          return;
        }
        if (property.equals("customDataType")) {
          agent.target.setCustomDataType((String) value);
          return;
        }
        if (property.equals("name")) {
          agent.target.setName((String) value);
          return;
        }
        if (property.equals("processVar")) {
          agent.target.setProcessVar((String) value);
          return;
        }
        throw new NonExistingPropertyException(property);
      }
    }
    BindableProxyFactory.addBindableProxy(AssignmentRow.class, new BindableProxyProvider() {
      public BindableProxy getBindableProxy(Object model, InitialState state) {
        return new org_jbpm_designer_client_shared_AssignmentRowProxy((AssignmentRow) model, state);
      }
      public BindableProxy getBindableProxy(InitialState state) {
        return new org_jbpm_designer_client_shared_AssignmentRowProxy(state);
      }
    });
    class org_jboss_errai_ui_shared_api_LocaleProxy extends Locale implements BindableProxy {
      private BindableProxyAgent<Locale> agent;
      public org_jboss_errai_ui_shared_api_LocaleProxy(InitialState initialState) {
        this(new Locale(), initialState);
      }

      public org_jboss_errai_ui_shared_api_LocaleProxy(Locale target, InitialState initialState) {
        agent = new BindableProxyAgent<Locale>(this, target, initialState);
        agent.propertyTypes.put("locale", new PropertyType(String.class, false, false));
        agent.propertyTypes.put("label", new PropertyType(String.class, false, false));
        agent.copyValues();
      }

      public BindableProxyAgent getBindableProxyAgent() {
        return agent;
      }

      public void updateWidgets() {
        agent.updateWidgetsAndFireEvents();
      }

      public Locale unwrap() {
        return agent.target;
      }

      public Locale deepUnwrap() {
        final Locale clone = new Locale();
        clone.setLocale(agent.target.getLocale());
        clone.setLabel(agent.target.getLabel());
        return clone;
      }

      public boolean equals(Object obj) {
        if (obj instanceof org_jboss_errai_ui_shared_api_LocaleProxy) {
          obj = ((org_jboss_errai_ui_shared_api_LocaleProxy) obj).unwrap();
        }
        return agent.target.equals(obj);
      }

      public int hashCode() {
        return agent.target.hashCode();
      }

      public String toString() {
        return agent.target.toString();
      }

      public String getLocale() {
        return agent.target.getLocale();
      }

      public void setLocale(String locale) {
        String oldValue = agent.target.getLocale();
        agent.target.setLocale(locale);
        agent.updateWidgetsAndFireEvent("locale", oldValue, locale);
      }

      public String getLabel() {
        return agent.target.getLabel();
      }

      public void setLabel(String label) {
        String oldValue = agent.target.getLabel();
        agent.target.setLabel(label);
        agent.updateWidgetsAndFireEvent("label", oldValue, label);
      }

      public Object get(String property) {
        if (property.equals("locale")) {
          return getLocale();
        }
        if (property.equals("label")) {
          return getLabel();
        }
        throw new NonExistingPropertyException(property);
      }

      public void set(String property, Object value) {
        if (property.equals("locale")) {
          agent.target.setLocale((String) value);
          return;
        }
        if (property.equals("label")) {
          agent.target.setLabel((String) value);
          return;
        }
        throw new NonExistingPropertyException(property);
      }
    }
    BindableProxyFactory.addBindableProxy(Locale.class, new BindableProxyProvider() {
      public BindableProxy getBindableProxy(Object model, InitialState state) {
        return new org_jboss_errai_ui_shared_api_LocaleProxy((Locale) model, state);
      }
      public BindableProxy getBindableProxy(InitialState state) {
        return new org_jboss_errai_ui_shared_api_LocaleProxy(state);
      }
    });
  }
}