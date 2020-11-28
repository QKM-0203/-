package com.base;

import java.util.Calendar;
import java.util.Scanner;

public class calendar {
    public static void main(String[] args) {
        System.out.println("Enter full year (e.g.,2012):");
        Scanner scanner = new Scanner(System.in);
        int year=scanner.nextInt();
        System.out.println("Enter month as a number between 1 and 12:");
        int month=scanner.nextInt();
        printMonth(year,month);
        printbodymonth(year,month);
        String s = scanner.nextLine();
        String[] split = s.split("\\s+");
    }

    private static void printbodymonth(int year, int month) {
        int startmonthday=getstartmonthday(year,month);
        int monthDay=getmonthsumday(year,month);
        //System.out.println(startmonthday);
        for(int i=0;i<startmonthday;i++){
            System.out.print("    ");
        }
        for(int i=1;i<=monthDay;i++){
            System.out.printf("%4d",i);
            if((i+startmonthday)%7==0) System.out.println("");
        }
    }

    private static int getstartmonthday(int year, int month) {
        final int START_DAY=3;
        int totalDAYs=getsunday(year,month);
        return (totalDAYs+START_DAY)%7;

    }

    private static int getsunday(int year, int month) {
        int total=0;
        for(int i=1800;i<year;i++){
            if(isleapyear(i))
                total+=366;
            else total+=365;
        }
        for(int i=1;i<month;i++){
            total+=getmonthsumday(year,i);
        }
        return total;
    }

    private static int getmonthsumday(int year,int month) {
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }else if(month==4||month==6||month==9|month==11)
            return 30;
        else return isleapyear(year)?29:28;
    }

    private static boolean isleapyear(int year) {
        if(year%400==0 ||(year%100!=0 && year%4==0))
            return true;
        else return false;
    }

    private static void  printMonth(int year,int month){
        System.out.println("       "+getmonth(month) +" " +year);
        System.out.println("---------------------------");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
    }

    private static String getmonth(int month) {
        String monthname=null;
        switch(month){
            case 1:   monthname="January"; break;
            case 2:  monthname="February"; break;
            case 3:  monthname= "March"; break;
            case 4:  monthname= "April"; break;
            case 5:  monthname= "May"; break;
            case 6: monthname= "June"; break;
            case 7:  monthname= "July"; break;
            case 8: monthname= "August"; break;
            case 9:  monthname="September"; break;
            case 10: monthname= "October"; break;
            case 11:  monthname= "November"; break;
            case 12:  monthname= "December"; break;
        }
        return monthname;
    }
}
