package org.jboss.errai.marshalling.client.api;

import java.util.List;
import org.guvnor.common.services.shared.test.Failure;
import org.guvnor.common.services.shared.test.TestResultMessage;
import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public class Marshaller_o_g_c_s_s_t_TestResultMessage_1_Impl implements GeneratedMarshaller<TestResultMessage> {
  private TestResultMessage[] EMPTY_ARRAY = new TestResultMessage[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  private Marshaller<Integer> java_lang_Integer = Marshalling.getMarshaller(Integer.class);
  private Marshaller<Long> java_lang_Long = Marshalling.getMarshaller(Long.class);
  private Marshaller<List> java_util_List = Marshalling.getMarshaller(List.class);
  public TestResultMessage[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$154633507__1195259493_identifier(TestResultMessage instance) /*-{
    return instance.@org.guvnor.common.services.shared.test.TestResultMessage::identifier;
  }-*/;

  private native static void _$154633507__1195259493_identifier(TestResultMessage instance, String value) /*-{
    instance.@org.guvnor.common.services.shared.test.TestResultMessage::identifier = value;
  }-*/;

  private native static int _$154633507__104431_runCount(TestResultMessage instance) /*-{
    return instance.@org.guvnor.common.services.shared.test.TestResultMessage::runCount;
  }-*/;

  private native static void _$154633507__104431_runCount(TestResultMessage instance, int value) /*-{
    instance.@org.guvnor.common.services.shared.test.TestResultMessage::runCount = value;
  }-*/;

  private native static Long _$154633507__398795216_runTime(TestResultMessage instance) /*-{
    return instance.@org.guvnor.common.services.shared.test.TestResultMessage::runTime;
  }-*/;

  private native static void _$154633507__398795216_runTime(TestResultMessage instance, Long value) /*-{
    instance.@org.guvnor.common.services.shared.test.TestResultMessage::runTime = value;
  }-*/;

  private native static List _$154633507__65821278_failures(TestResultMessage instance) /*-{
    return instance.@org.guvnor.common.services.shared.test.TestResultMessage::failures;
  }-*/;

  private native static void _$154633507__65821278_failures(TestResultMessage instance, List<Failure> value) /*-{
    instance.@org.guvnor.common.services.shared.test.TestResultMessage::failures = value;
  }-*/;

  public TestResultMessage demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(TestResultMessage.class, objId);
    }
    TestResultMessage entity = new TestResultMessage();
    a1.recordObject(objId, entity);
    if ((obj.containsKey("identifier")) && (!obj.get("identifier").isNull())) {
      _$154633507__1195259493_identifier(entity, java_lang_String.demarshall(obj.get("identifier"), a1));
    }
    if ((obj.containsKey("runCount")) && (!obj.get("runCount").isNull())) {
      _$154633507__104431_runCount(entity, java_lang_Integer.demarshall(obj.get("runCount"), a1));
    }
    if ((obj.containsKey("runTime")) && (!obj.get("runTime").isNull())) {
      _$154633507__398795216_runTime(entity, java_lang_Long.demarshall(obj.get("runTime"), a1));
    }
    if ((obj.containsKey("failures")) && (!obj.get("failures").isNull())) {
      a1.setAssumedElementType("org.guvnor.common.services.shared.test.Failure");
      _$154633507__65821278_failures(entity, java_util_List.demarshall(obj.get("failures"), a1));
    }
    return entity;
  }

  public String marshall(TestResultMessage a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.guvnor.common.services.shared.test.TestResultMessage\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"identifier\":").append(java_lang_String.marshall(a0.getIdentifier(), a1)).append(",").append("\"runCount\":").append(java_lang_Integer.marshall(a0.getRunCount(), a1)).append(",").append("\"runTime\":").append(java_lang_Long.marshall(_$154633507__398795216_runTime(a0), a1)).append(",").append("\"failures\":").append(java_util_List.marshall(a0.getFailures(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}