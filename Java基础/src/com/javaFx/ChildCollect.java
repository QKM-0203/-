package com.id.itera;

import javafx.scene.chart.AxisBuilder;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Callable;


/*求子串，用set可以去重但顺序是乱的
//但用LinkedHashset可以是正确的顺序
public class ChildCollect {
    private static String FatherStr;
    public static String GetChildCollect(String ChildStr,int CharIndex,List<String> list){
        ChildStr += FatherStr.charAt(CharIndex);
        if (CharIndex==FatherStr.length()-1){
              list.add(ChildStr);
              return "";
        } else{
            list.add(ChildStr);
            GetChildCollect(ChildStr,CharIndex+1,list);
        }
        return ChildStr;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FatherStr=scanner.next();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<FatherStr.length();i++){
            GetChildCollect("",i,list);
        }
        System.out.println(list);
    }
} */
/*子集
public class ChildCollect {
    private static String FatherStr;
    private static int[] Book = {0,0,0,0};
    public static String GetChildCollect(String ChildStr, int CharIndex, List<String> list) {
        ChildStr += FatherStr.charAt(CharIndex);
        list.add(ChildStr);
        if (CharIndex == FatherStr.length() - 1) {
            return "";
        }
        for (int i = CharIndex+1; i < FatherStr.length(); i++) {
            if (Book[i] == 0) {
                Book[i] = 1;
                GetChildCollect(ChildStr, i, list);
                Book[i] = 0;
            }

        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FatherStr = scanner.next();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < FatherStr.length(); i++) {
            Book[i]=1;
            GetChildCollect("", i, list);
        }
        System.out.println(list);
    }
}
*/
public class ChildCollect {
    private static String FatherStr;
    private static int[] Book = {0,0,0,0};
    public static String GetChildCollect(String ChildStr, int CharIndex, Set<String> set) {
        ChildStr += FatherStr.charAt(CharIndex);

        if (ChildStr.length() == FatherStr.length()) {
            char[] chars = ChildStr.toCharArray();
            set.add(Arrays.toString(chars));
            return "";
        }
        for (int i = 0; i < FatherStr.length(); i++) {
            if (Book[i] == 0) {
                Book[i] = 1;
                GetChildCollect(ChildStr, i, set);
                Book[i] = 0;
            }

        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FatherStr = scanner.next();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < FatherStr.length(); i++) {
            Book[i]=1;
            GetChildCollect("", i, set);
            Book[i]=0;
        }
        System.out.println("[");
        int j=0;
        for(String i:set){
            j++;
            System.out.print(i);
            if(j!=set.size()) System.out.println(",");
        }
        System.out.println("\n]");
        //System.out.println(list.size());
    }

}