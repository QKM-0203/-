package com.base;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.String;
public class ThirdPeopleGame {
    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();
        //生成牌
        poker.add("大王");
        poker.add("小王");
        String[] hua={"♠","♦","♣","♥"};
        String[] number={"2","A","K","O","J","10","9","8","7","6","5","4","3"};
        for (String c : hua) {
            for (String s : number) {
                poker.add(c+s);
            }
        }
        Collections.shuffle(poker);//洗牌
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> DiPai = new ArrayList<>();

        //发牌
        for (int i = 0; i < poker.size(); i++) {
            if(i>=51) DiPai.add(poker.get(i));
            else if(i%3==0){
                play1.add(poker.get(i));
            }
            else if(i%3==1){
                play2.add(poker.get(i));
            }
            else play3.add(poker.get(i));
        }
        Collections.sort(play1);
        System.out.println(play1);
        System.out.println(play2);
        System.out.println(play3);
        System.out.println(DiPai);

    }
}
