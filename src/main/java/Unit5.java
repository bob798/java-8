import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Unit5 {
    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red",10));
        apples.add(new Apple("red",11));
        apples.add(new Apple("red",13));
        apples.add(new Apple("blue",15));
        apples.add(new Apple("black",18));

        apples.stream().filter(a -> (a.getColor().equals("red"))).collect(toList());

        /*筛选各异的元素*/
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 4, 1, 5);
        numbers.stream().filter(i -> i % 2 == 0).distinct().collect(toList()).forEach(System.out::println);
        /*output
        2
        4
        * */

//        执行过程，1.创建数据流-stream<Integer> 2. 过滤偶数-filter 3. 去重-distinct


        /*截短流：返回不超过给定长度的流*/
        apples.stream().filter(apple ->
            apple.getWeight() > 10
        ).limit(1).forEach(System.out::println);

//        执行过程 1. 创建数据流 2. 过滤 3. 截断 4. 终端操作

        /*跳过元素:扔掉前几个元素的流*/
        apples.stream().filter(apple -> apple.getWeight() > 10).skip(2).forEach(System.out::println);

        /*筛选前两个红色苹果*/
        apples.stream().filter(apple -> apple.getColor().equals("red")).limit(2).forEach(System.out::println);



    }
}
