import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BehaverParam {

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(280);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(80);

        List<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        apples.add(apple2);
        apples.sort((Apple a1, Apple a2) ->(a1.getWeight().compareTo(a2.getWeight())));
        for (Apple a : apples) {
            System.out.println(a.toString());
        }

        List<Apple> list = filter(apples, (Apple a) -> (200 > a.getWeight()));

//        List<Apple> list = filter(apples, (Apple a) -> ("red".equals(a.getColor())));
        for (Apple apple:list) {
            System.out.println(apple.toString());
        }

        Thread thread = new Thread(() -> System.out.println("Hello World"));
        thread.run();
//        Thread.sleep(2000);

    }
}
