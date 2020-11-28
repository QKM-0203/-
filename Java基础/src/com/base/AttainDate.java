package com.base;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class AttainDate {
    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.print(gregorianCalendar.get(GregorianCalendar.YEAR)+"-");
        System.out.print(gregorianCalendar.get(GregorianCalendar.MONTH)+1+"-");
        System.out.println(gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));
        gregorianCalendar.setTimeInMillis(1234567898765L);
        System.out.println(gregorianCalendar.getTime());
    }
}
