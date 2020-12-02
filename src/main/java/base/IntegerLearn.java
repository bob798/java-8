package base;

public class IntegerLearn {
    public static void main(String[] args) {
        Integer i = 4;
        System.out.println(Integer.toString(8, 2));
        System.out.println("hexString:::" + Integer.toHexString(256));
//        int get = (Integer.getInteger("4"));
//        System.out.println(get);

        System.out.println(Integer.decode("010"));

        System.out.println(Integer.reverse(2));
        System.out.println(Integer.MAX_VALUE);

        System.out.println("bitcount ::: " + Integer.bitCount(9));
        System.out.println("numberOfTrailingZeros ::: " + Integer.numberOfTrailingZeros(1001));
        System.out.println("numberOfLeadingZeros ::: " + Integer.numberOfLeadingZeros(8));
        System.out.println("lowestOneBit ::: " + Integer.lowestOneBit(3334444));
        System.out.println("highestOneBit ::: " + Integer.highestOneBit(17));

        System.out.println("hashCode ::: "+i.hashCode());
        System.out.println(i.equals(4));

        int result = i.compareTo(5);
        System.out.println("comparTo result:::" + result);
    }
}
