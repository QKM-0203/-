package com.base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class New {
    public static void main(String[] args) {
      int[] num={4,9,5};
      int[] nums={9,4,9,8,4};
      intersect(num,nums);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        //排序方法
        int[] result=new int[Math.min(nums1.length,nums2.length)];
        int k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1=0,index2=0;
        while(index1<nums1.length && index2<nums2.length){
            if(nums1[index1]<nums2[index2]){
                index1++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;
            }else{
                result[k++]=nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(result,0,k);

        /*哈希表方法
        int[] result=new int[1000];
        int k=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nums=nums1.length<nums2.length?nums1:nums2;
        for (int i : nums) {
            if (map.containsKey(i)==false) {
                map.put(i,1);
            } else {
                int val = map.get(i)+1;
                map.put(i,val);
            }
        }
        System.out.println(map);
        nums=nums1.length<nums2.length?nums2:nums1;
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i)-1);
                if(map.get(i)>=0)
                    result[k++]=i;
            }
        }
        return Arrays.copyOfRange(result,0,k);
    }*/

}
}
