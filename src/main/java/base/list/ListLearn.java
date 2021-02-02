package base.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*******************************************************************************
 * Copyright 2018 agilestar, Inc. All Rights Reserved
 * agileCloud
 * list
 * Created by bob on 18-9-27.
 * Description:
 *******************************************************************************/
public class ListLearn {

    public static void main(String[] args) {
        List listSize = new ArrayList();
        listSize.add(null);
        listSize.add(null);
        System.out.println(listSize.size());
        System.out.println(listSize.toString());
//        System.out.println(listEmpty.size());

        listSize.clear();
        listSize.add(1);
        listSize.add(2);
        System.out.println("正常 ：："+listSize.toString());

        // 索引删除
        listSize.remove(1);
        // 值删除
        listSize.remove(Integer.valueOf(1));

        System.out.println("list :::" + listSize.toString());

        // list 颠倒顺询
        Collections.reverse(listSize);
        System.out.println("reverse list :::" + listSize.toString());
    }
}
