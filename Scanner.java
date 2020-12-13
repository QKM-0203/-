import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//输入挂（利用分隔符的类和BufferedReader来写）比Scanner效率高
//StringTokenizer分割字符串的类比split快很多
/*
    1. StringTokenizer(String str)
    构造一个用来解析 str 的 StringTokenizer 对象。java 默认的分隔符是空格("")、制表符(\t)、换行符(\n)、回车符(\r)。
    2. StringTokenizer(String str, String splitChar)
    构造一个用来解析 str 的 StringTokenizer 对象，并提供一个指定的分隔符。
    3. StringTokenizer(String str, String splitChar, boolean returnSplitChar)
    构造一个用来解析 str 的 StringTokenizer 对象，并提供一个指定的分隔符，同时，指定是否返回分隔符。
    1. int countTokens()：返回nextToken方法被调用的次数。
    2. boolean hasMoreTokens()：返回是否还有分隔符。
    3. boolean hasMoreElements()：判断枚举 （Enumeration） 对象中是否还有数据。
    4. String nextToken()：返回从当前位置到下一个分隔符的字符串。
    5. Object nextElement()：返回枚举 （Enumeration） 对象的下一个元素。
    6. String nextToken(String split)：与 4 类似，以指定的分隔符返回结果。
 */
class Input{
    StringTokenizer toke;
    BufferedReader buf;
    public Input() {
        //获取一个从键盘输入的缓冲区的字符输入流，
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    //判断还有元素吗
    boolean hasNext()
    {

        //判断是否存在分割符
        while(toke==null||!toke.hasMoreTokens())
        {
            try {
                //字符缓冲输入流获取一行,默认分割符是空格，制表符，回车
                toke = new StringTokenizer(buf.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    String next()
    {
        //判断还有元素吗
        if(hasNext())
            //返回从当前字符到下一个分隔符的字符或者字符串
            return toke.nextToken();
        return null;
    }
    int nextInt()
    {
        return Integer.parseInt(next());
    }

    float nextFloat()
    {
        return Float.parseFloat(next());
    }
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
    }

    public static void main(String[] args){
        Input in = new Input();
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            //输入
            String n1 = in.next();
            //输出
            System.out.println(n1);
        }
        //简单的StringTokenizer的使用
        StringTokenizer stringTokenizer = new StringTokenizer("sd ffg vb", " ");
        System.out.println(stringTokenizer.nextToken());

    }
}