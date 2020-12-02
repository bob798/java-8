package map;

import java.util.HashMap;
import java.util.Map;

public class MapLearn {
    public static void main(String[] args) {

        /*
        先来了解一些移位运算符
          <<  左移运算法 相当与乘2
          >>  右移运算符 相当于除2
          <<< 无符号右移，忽略符号位，空位都以0补（只是对32位和64位有意义）

          引用 http://www.cnblogs.com/hongten/p/hongten_java_yiweiyunsuangfu.html
         */
        int num = 16;

        //16 二进制
        binary(num); // 输出 10000
        // 左移1位
        num = num << 1;
        binary(num); // 输出 100000
        //右移2为
        num = num >> 2; // 输出 1000

        binary(num);

    }

    private static void binary(int i) {
        System.out.println(Integer.toBinaryString(i));
    }
}
