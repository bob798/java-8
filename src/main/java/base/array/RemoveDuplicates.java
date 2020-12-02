package array;

/*******************************************************************************
 * Copyright 2018 agilestar, Inc. All Rights Reserved
 * agileCloud
 * array
 * Created by bob on 18-8-18.
 * Description:  
 *******************************************************************************/
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,2}));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }

    private static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {

                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
