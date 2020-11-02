package com.java;

public class Cache {
    private final String name;
    private static final int MAX_SIZE = 10;
    private static final Cache[] cache = new Cache[MAX_SIZE];
    private static int pos = 0;
    //不能通过构造获取对象
    private Cache(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //通过该方法获取对象
    public static  Cache valueOf(String name){
        for (int i = 0; i < cache.length; i++) {
              if (cache[i] != null && cache[i].getName().equals(name)){
                  return cache[i];
              }
        }
        if (pos == MAX_SIZE) {
            cache[0] = new Cache(name);
            pos = 1;
        }else{
            cache[pos++] = new Cache(name);
        }
        return cache[pos-1];
    }

}
