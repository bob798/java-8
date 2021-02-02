package algorithm.list;

import org.junit.Test;

import java.util.List;


public class IntersectionListTest {

  @Test
  public void intersection() {
    List<User> list1 = List.of(User.builder().name("11").age(1).build(), User.builder().name("11").age(1).build(), User.builder().name("11").age(1).build(), User.builder().name("22").age(2).build());
    List<User> list2 = List.of(User.builder().name("11").age(1).build(), User.builder().name("11").age(1).build(), User.builder().name("33").age(3).build());

    List<User> intersection = (List<User>) IntersectionList.intersection(list1, list2);
    intersection.forEach(System.out::print);
    System.out.println("-------------");
    List<User> intersectionOfCollectionUtil = (List<User>) IntersectionList.intersectionOfCollectionUtil(list1, list2);
    intersectionOfCollectionUtil.forEach(System.out::print);


  }


}
