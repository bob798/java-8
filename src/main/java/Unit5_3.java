import java.util.*;

public class Unit5_3 {
    public static void main(String[] args) {
        /*----------查找和匹配------------*/
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red",10));
        apples.add(new Apple("red",11));
        apples.add(new Apple("red",13));
        apples.add(new Apple("blue",15));
        apples.add(new Apple("black",18));

        if (apples.stream().anyMatch(apple -> apple.getColor().equals("red"))) {
            System.out.println("apples exist red apple");
        }

        Map<String, Object> appleMap = new HashMap<>();
        appleMap.put("1", new Apple("red", 10));
        appleMap.put("2", null);
        if (appleMap.values().stream().anyMatch(Objects::isNull)) {
            System.out.println("appleMap is exist null");
        }else {
            System.out.println("appleMap is not  exist null");
        }

        Map<String, Object> appleNoN = new HashMap<>();
        appleNoN.put("1", new Apple("red", 10));
        appleNoN.put("2", new Apple("red", 12));
        if (appleNoN.values().stream().anyMatch(Objects::isNull)) {
            System.out.println("appleNoN is exist null");
        } else {
            System.out.println("appleNoN is not  exist null");
        }
    }
}
