package com.base;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//动态分布
//从小到大会有重复元素放进去，就是说如果只考虑价值最高可以重复放，就可以选择从小到大
//从大到小就不会 有重复的，只能放进去一个，然后求最大价值
public class DynamicProgramming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入背包重量和物品个数");
        int BagWeight=scanner.nextInt();
        int ObjectNumber=scanner.nextInt();
        int[] df=new int[BagWeight+1];
        for (int i = 0; i < df.length; i++) {
            df[i]=0;
        }
        HashMap<Integer, Integer> ObjectMap = new HashMap<>();
        for(int j=1;j<=ObjectNumber;j++){
            ObjectMap.put(scanner.nextInt(),scanner.nextInt());//输入重量和价值
        }
        Set<Integer> set = ObjectMap.keySet();
        for (Integer integer : set) {
            /*倒序，0,1背包
             4 3
             1 1500
             3 2000
             4 3000
             3500
             */
            for(int j=BagWeight;j>=integer;j--){
                df[j]=Math.max(df[j],df[j-integer]+ObjectMap.get(integer));
            }
            /*正序 完全背包
            4 3
            1 1500
            3 2000
            4 3000
            6000
            for(int j=integer;j<=BagWeight;j++){
                df[j]=Math.max(df[j],df[j-integer]+ObjectMap.get(integer));
            }*/
        }
        System.out.println(df[BagWeight]);


    }
}
