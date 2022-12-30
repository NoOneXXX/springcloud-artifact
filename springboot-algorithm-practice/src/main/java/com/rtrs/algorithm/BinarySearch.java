package com.rtrs.algorithm;

public class BinarySearch {
    public static int bsr(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while (left <= right)
        {
            int mid = (left + right) / 2;
            //target is found
            if (nums[mid] == target)
                return mid;

            if (target < nums[mid])
            {
                //discard all elements in the right search space
                right = mid - 1;
            }else{
                //discard all left numbers in the left search space
                left = mid + 1;
            }
        }
        //if target is not exists;
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 11, 45, 445, 478, 54254, 14477455, 525445545};
        int target =  bsr(nums, 45);
        System.out.println(target);

        int one = 3,two = 4;
        System.out.println(">>1 value" + ((one + two) >> 1));
    }
}
