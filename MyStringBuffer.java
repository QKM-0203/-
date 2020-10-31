package com.id.itera;

import java.util.Arrays;
//其实例出来的两个对象可以同时执行synchronized修饰的方法，互不影响。
// 当一个类中有两个方法使用关键字synchronized修饰时，
// 同一个对象在多线程中不能同时执行synchronized修饰的方法
public class MyStringBuffer {

    private final static int CAPACITY = 16;

    private static char[] chars;

    private static int count = 0;

    /*
    无参构造分配一个大小为16的数组空间
     */
    public MyStringBuffer(){
        chars = new char[CAPACITY];
    }

    /*
    生成一个具有确定的空间大小的数组
     */
    public MyStringBuffer(int capacity){
        chars = new char[capacity];
    }


    /*
    有参构造，传入一个字符串，并为该字符串开辟数组空间
     */
    public MyStringBuffer(String str){
        if (str == null) {
            throw new NullPointerException();
        }
        chars = new char[CAPACITY +str.length()];
        this.append(str);
    }


    /*
    获取字符串的长度
     */
    public  synchronized int length(){
        return count;
    }


    /*
    获取当前数组的空间大小
     */
    public synchronized int capacity() {
        return chars.length;
    }



    /*
    设置一个具有指定长度的字符串，返回当前对象.
    若指定长度大于当前字符串的长度，则在后添加'\u0000';
     */
    public synchronized void setLength(int newLength){
        if(newLength < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (newLength > count){
            Arrays.fill(chars,count,newLength,'\u0000');
        } else{
            chars = Arrays.copyOf(chars,newLength);
        }
        count = newLength;
    }



   /*
     返回此序列中的索引，该索引是从给定 index 偏移 codePointOffset 个代码点后得到的
    */
    public synchronized int offsetByCodePoints(int index, int codePointOffset){
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        return index + codePointOffset;
    }




    /*
    将空间增大为length长度大小
     */
    public synchronized void AddCapacity(int length){
        chars = Arrays.copyOf(chars,length);
    }




    /*
    将序列里面从srcBegin-(srcEnd-1)的元素复制到dst数组中去，从dstBegin下标开始
    数组为null抛出异常空指针异常，下标越界抛出索引越界异常
     */
    public synchronized void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin){
        if (dst == null){
            throw new NullPointerException();
        }
        if (srcBegin < 0 || srcBegin > srcEnd || dstBegin+srcEnd-srcBegin > dst.length){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(chars,srcBegin,dst,dstBegin,srcEnd-srcBegin);
    }




    /*
    修改当前序列里索引为index的值，修改为ch
    下标越界抛出索引越界异常
     */
    public synchronized void setCharAt(int index, char ch){
        if (index < 0 || index >= count){
            throw new IndexOutOfBoundsException();
        }
        chars[index] = ch;
    }



    /*
    增加一个字符串到该字符串的末尾；
     */
    public synchronized MyStringBuffer append(String str){
        if (str == null) {
            str = "null";
        }
        if ((chars.length - count) < str.length()){
            AddCapacity(capacity()+str.length()*2);
            str.getChars(0, str.length(),chars, count);
        } else{
            str.getChars(0, str.length(),chars, count);
        }
        count += str.length();
        return this;
    }


    /*
    将 char 参数的字符串表示形式追加到此序列。
     */
    public synchronized MyStringBuffer append(char ch){
        return this.append(String.valueOf(ch));
   }




    /*
    将 int 参数的字符串表示形式追加到此序列。
     */
    public synchronized MyStringBuffer append(int ch){
        return this.append(String.valueOf(ch));
    }



    /*
    将 float 参数的字符串表示形式追加到此序列。
     */
    public synchronized MyStringBuffer append(float ch){
        return this.append(String.valueOf(ch));
    }


    /*
    将 double 参数的字符串表示形式追加到此序列。
     */
    public synchronized MyStringBuffer append(double ch){
        return this.append(String.valueOf(ch));
    }


    /*
    将 long 参数的字符串表示形式追加到此序列。
     */
    public synchronized MyStringBuffer append(long ch){
        return this.append(String.valueOf(ch));
    }


    /*
    将 boolean 参数的字符串表示形式追加到序列。
     */
    public synchronized MyStringBuffer append(boolean ch){
        return this.append(String.valueOf(ch));
    }


    /*
    将 char 数组参数的字符串表示形式追加到此序列。
     */
    public synchronized MyStringBuffer append(char[] ch){
        return this.append(String.valueOf(ch));
    }


    /*
    增加一个String型的数组的字符串形式到该序列末尾
     */
    public synchronized MyStringBuffer append(String[] ch){
        String str="";
        for (int i = 0;i < ch.length;i++){
            str =str+ch[i];
        }
        return this.append(String.valueOf(str));
    }




   /*
    将指定的 CharSequence 追加到该序列
    */
    public synchronized MyStringBuffer append(CharSequence s) {
        String s1=(String)s;
        return this.append(s1);
    }



    /*
   追加 Object 参数的字符串表示形式。
    */
    public synchronized MyStringBuffer append(Object o) {
        return append(String.valueOf(o));
    }




    /*
     将指定的 StringBuffer 追加到此序列中。
     */
    public synchronized MyStringBuffer append(StringBuffer str) {
        return append(String.valueOf(str));
    }


    /*
    将指定 CharSequence 的子序列追加到此序列。
    下标越界抛出异常，
     */
    public synchronized MyStringBuffer append(CharSequence s, int start, int end)
    {
        if (s == null) {
            s = "null";
        }
        if (start < 0 || start > end || end > s.length()) {
            throw new IndexOutOfBoundsException(
                    "start " + start + ", end " + end + ", s.length() "
                            + s.length());
        }
        CharSequence charSequence = s.subSequence(start, end);
        return append((String)charSequence);
    }



   /*
   将 char 数组参数的子数组的字符串表示形式追加到此序列。
    */
    public synchronized MyStringBuffer append(char[] str, int offset, int len) {
        if( offset < 0 || offset > str.length || len > str.length) {
            throw new StringIndexOutOfBoundsException();
        }
        String s = String.valueOf(str);
        String substring = s.substring(offset, len);
        return append(substring);
    }










    public synchronized char charAt(int index) {
        if (index < 0 || index >= count )
            throw new StringIndexOutOfBoundsException(index);
        return chars[index];
    }


    public synchronized int codePointAt(int index){
        int i = 0;
        if (index >= count || index < 0) throw new StringIndexOutOfBoundsException(index);
        for(i = 0;i < count;i++){
          if(i == index) break;
        }
        return (int)chars[i];
    }





    public synchronized int codePointBefore(int index){
        int i = 0;
        if (index > count || index <=0 ) throw new StringIndexOutOfBoundsException(index);
        for(i = 0;i < count;i++){
            if(i == index-1) break;
        }
        return (int)chars[i];
    }




    public synchronized int codePointCount(int beginIndex, int endIndex){
        if (beginIndex < 0 || endIndex > count || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        return endIndex-beginIndex;
    }




    /*
    移除此序列的子字符串中的字符。该子字符串从指定的 start 处开始，一直到索引 end - 1 处的字符，
    如果不存在这种字符，则一直到序列尾部。如果 start 等于 end，则不发生任何更改。
     */
    public synchronized MyStringBuffer delete(int start, int end){
        if (start < 0 || start > length() || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        if (end > count) end = count;
        if (start == end) return this;
        System.arraycopy(chars, end, chars, start, capacity() - end);
        count = count-end+start;
        return this;
    }



    /*
    移除此序列指定位置的 char。此序列将缩短一个 char。
     */
    public synchronized MyStringBuffer deleteCharAt(int index){
        if (index < 0 || index >= count){
            throw new StringIndexOutOfBoundsException("String index out of range: "+index);
        }
        System.arraycopy(chars, index+1, chars, index,  capacity() - (index + 1));
        count = count-1;
        return this;
    }




    /*
   使用给定 String 中的字符替换此序列的子字符串中的字符。该子字符串从指定的 start 处开始，一直到索引 end - 1 处的字符，
   如果不存在这种字符，则一直到序列尾部。先将子字符串中的字符移除，然后将指定的 String 插入 start。（如果需要，序列将延长以适应指定的字符串。）
   */
    public synchronized MyStringBuffer replace(int start, int end, String str){
        if (start < 0 || start > count || start > end){
            throw new StringIndexOutOfBoundsException();
        }
        if (start == end) return this;
        if(end > count) end = count;
        if (CAPACITY -count < str.length()) {
            AddCapacity(str.length()*2+ CAPACITY);
        }
        System.arraycopy(chars,end,chars,start + str.length(),count-end);
        str.getChars(0,str.length(),chars,start);
        count = count- (end-start) + str.length();
        return this;
    }





    /*
    返回一个新的字符序列，该字符序列是此序列的子序列。
     */
    public synchronized CharSequence subSequence(int start,int end){
        if (start < 0 || start > end || end > count ) {
            throw new IndexOutOfBoundsException();
        }
        return (CharSequence) String.valueOf(chars).substring(start,end);
    }


   /*
   返回一个新的 String，它包含此字符序列当前所包含的字符子序列。该子字符串始于指定索引处的字符，一直到此字符串末尾。
    */
    public synchronized String substring(int start){
        if (start < 0 || start > count) {
            throw new StringIndexOutOfBoundsException();
        }
        return String.valueOf(chars).substring(start);
    }




    /*
    将 str 数组参数的子数组的字符串表示形式插入此序列中。其中子数组从指定的 offset 开始，包含 len 个 char。
    子数组的字符将被插入 index 所指示的位置。此序列的长度将增加 len 个 char。
     */
    public synchronized MyStringBuffer insert(int index, char[] str, int offset, int len){
        System.out.println(count );
        System.out.println(length());
         if (index < 0 || index > count || offset < 0 || offset+len > str.length || len < 0){
             throw new StringIndexOutOfBoundsException();
         }
         if (capacity() < index+len) AddCapacity(len*2+ CAPACITY);
         System.arraycopy(chars ,index,chars,index+len,count-index);
         System.arraycopy(str,offset,chars,index,len);
         count += len;
         return this;
    }




    /*
    将字符串插入此字符序列中。
     */
    public synchronized MyStringBuffer insert(int offset, String str){
        if (offset < 0 || offset > count) throw new StringIndexOutOfBoundsException("String index out of range:"+offset);
        if (str == null) str = "null";
        if (capacity() - count < str.length()){
            AddCapacity((capacity()+str.length()*2));
        }
        System.arraycopy(chars,offset,chars,offset + str.length(),count-offset);
        str.getChars(0,str.length(),chars,offset);
        count += str.length();
        return this;
    }




    /*
    将 Object 参数的字符串表示形式插入此字符序列中。
     */
    public synchronized MyStringBuffer insert(int offset, Object obj){
        return insert(offset,String.valueOf(obj));
    }



    /*
   将 char 数组参数的字符串表示形式插入此序列中。
    */
    public synchronized MyStringBuffer insert(int offset, char[] str){
        return insert(offset,String.valueOf(str));
    }


    /*
    将指定 CharSequence 插入此序列中。
     */
    public synchronized MyStringBuffer insert(int dstOffset, CharSequence s){
        return insert(dstOffset,String.valueOf(s));
    }


    /*
    将指定 CharSequence 的子序列插入此序列中。
    */
    public synchronized MyStringBuffer insert(int dstOffset, CharSequence s, int start, int end){
        if (start < 0 || end < 0 || start > end || end > s.length()) {
            throw new IndexOutOfBoundsException(
                    "start " + start + ", end " + end + ", s.length() "
                            + s.length());
        }
        return insert(dstOffset,String.valueOf(s.subSequence(start,end)));
    }



   /*
   将 boolean 参数的字符串表示形式插入此序列中。
    */
    public synchronized MyStringBuffer insert(int offset, boolean b){
         return insert(offset,String.valueOf(b));
    }


   /*
   将 char 参数的字符串表示形式插入此序列中。
    */
    public synchronized MyStringBuffer insert(int offset, char c){
        return insert(offset,String.valueOf(c));
    }



    /*
    将 int 参数的字符串表示形式插入此序列中。
     */
    public synchronized MyStringBuffer insert(int offset, int i){
        return insert(offset,String.valueOf(i));
    }




    /*
    将 long 参数的字符串表示形式插入此序列中。
     */
    public synchronized MyStringBuffer insert(int offset, long l){
        return insert(offset,String.valueOf(l));
    }


   /*
   将 float 参数的字符串表示形式插入此序列中。
    */
    public synchronized MyStringBuffer insert(int offset, double d){
        return insert(offset,String.valueOf(d));
    }



   /*
   将 double 参数的字符串表示形式插入此序列中。
    */
    public synchronized MyStringBuffer insert(int offset, float f){
        return insert(offset,String.valueOf(f));
    }


   /*
   返回第一次出现的指定子字符串在该字符串中的索引。
    */
    public synchronized int indexOf(String str){
        return String.valueOf(this).indexOf(str);
    }


   /*
   从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引
    */
    public synchronized int indexOf(String str, int fromIndex){
        return String.valueOf(this).indexOf(str,fromIndex);
    }


   /*
   返回最右边出现的指定子字符串在此字符串中的索引。
    */
    public synchronized int lastIndexOf(String str){
        return String.valueOf(this).lastIndexOf(str);
    }



     /*
     返回最后一次出现的指定子字符串在此字符串中的索引
      */
    public synchronized int lastIndexOf(String str, int fromIndex){
        return String.valueOf(this).lastIndexOf(str,fromIndex);
    }


    /*
    将此字符序列用其反转形式取代。
     */
    public synchronized MyStringBuffer reverse(){
        int j=count-1;
        for(int i = 0;i < (count/2);i++){
            char PrevChar = chars[i];
            chars[i] = chars[j];
            chars[j] = PrevChar;
            j--;
        }
        return this;
    }
    @Override
    public String toString() {
        return String.valueOf(Arrays.copyOf(chars,count));
    }
}
