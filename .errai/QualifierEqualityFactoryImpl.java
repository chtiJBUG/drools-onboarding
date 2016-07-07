package org.jboss.errai.ioc.client;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Named;
import org.jboss.errai.ioc.client.api.ReplyTo;
import org.jboss.errai.ioc.client.api.ToSubject;
import org.jboss.errai.ui.client.widget.Table;
import org.uberfire.client.workbench.annotations.AssociatedResources;
import org.uberfire.client.workbench.annotations.Priority;

public class QualifierEqualityFactoryImpl implements QualifierEqualityFactory {
  private HashMap<String, AnnotationComparator> comparatorMap = new HashMap<String, AnnotationComparator>();
  public QualifierEqualityFactoryImpl() {
    comparatorMap.put("org.jboss.errai.ui.client.widget.Table", new AnnotationComparator<Table>() {
      @Override public boolean isEqual(Table a1, Table a2) {
        if (!a1.root().equals(a2.root())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(Table a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.root());
        return hash;
      }
    });
    comparatorMap.put("org.jboss.errai.ioc.client.api.ToSubject", new AnnotationComparator<ToSubject>() {
      @Override public boolean isEqual(ToSubject a1, ToSubject a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(ToSubject a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.jboss.errai.ioc.client.api.ReplyTo", new AnnotationComparator<ReplyTo>() {
      @Override public boolean isEqual(ReplyTo a1, ReplyTo a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(ReplyTo a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("javax.inject.Named", new AnnotationComparator<Named>() {
      @Override public boolean isEqual(Named a1, Named a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(Named a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.uberfire.client.workbench.annotations.AssociatedResources", new AnnotationComparator<AssociatedResources>() {
      @Override public boolean isEqual(AssociatedResources a1, AssociatedResources a2) {
        if (!Arrays.equals(a1.value(), a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(AssociatedResources a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.uberfire.client.workbench.annotations.Priority", new AnnotationComparator<Priority>() {
      @Override public boolean isEqual(Priority a1, Priority a2) {
        if (a1.value() != a2.value()) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(Priority a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
  }

  public boolean isEqual(Annotation a1, Annotation a2) {
    if (QualifierUtil.isSameType(a1, a2)) {
      if (comparatorMap.containsKey(a1.annotationType().getName())) {
        return ((AnnotationComparator) comparatorMap.get(a1.annotationType().getName())).isEqual(a1, a2);
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

  public int hashCodeOf(Annotation a1) {
    if (comparatorMap.containsKey(a1.annotationType().getName())) {
      return ((AnnotationComparator) comparatorMap.get(a1.annotationType().getName())).hashCodeOf(a1);
    } else {
      return a1.annotationType().hashCode();
    }
  }
}