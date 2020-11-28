package com.base;
public class DynamicDemo {
    public static void main(String[] args) {
        String[] str={"10", "0", "1"};
        System.out.println(findMaxForm(str,1,1));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
       int[][] df=new int[m+1][n+1];
        for (String str : strs) {
            int[] counter=counter(str);
            for(int i=m;i>=counter[0];i--){
                for(int j=n;j>=counter[1];j--){
                    df[i][j]=Math.max(df[i][j],df[i-counter[0]][j-counter[1]]+1);
                }
            }
        }
        return df[m][n];
    }


    public static int[] counter(String str) {
        int[] count=new int[2];
        for(char s:str.toCharArray()){
            count[s-'0']++;
        }
        return count;
    }
}
