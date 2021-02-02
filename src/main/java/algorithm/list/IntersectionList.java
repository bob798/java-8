package algorithm.list;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class IntersectionList {

  public static List intersection(List collectionA, List collectionB) {


    Iterator iterable = collectionA.iterator();
    List list = new ArrayList();
    while (iterable.hasNext()) {
      Object o = iterable.next();
      if (collectionB.contains(o)) {
        list.add(o);
      }
    }
    return list;
  }

  public static List intersectionOfCollectionUtil(List lista, List listb) {
    return (List) CollectionUtils.intersection(lista, listb);
  }
}
