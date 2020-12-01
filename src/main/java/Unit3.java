import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Unit3 {
    public static void main(String[] args) {
        /*
        * lambda 表达式 ： 参数 箭头 主体
        * (parameters) -> expression / {statements;}
        *
        * 方法引用，lambda表达式的快捷写法
        * 目标引用 分隔符 方法
        * Apple::getWeight
        * */


        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red",10));
        apples.add(new Apple("blue",15));

        apples.sort(
                (a1,a2) ->  a1.getWeight().compareTo(a2.getWeight())
        );
        System.out.println("-------正序--------");
        apples.forEach(System.out::println);
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println("-------倒叙--------");
        apples.forEach(System.out::println);
    }
}
