package cn.glbb.recursion;

import java.util.ArrayList;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(3 ,"A","B","C");
    }

    public static void hanoi(int n, String A, String B, String C){
        if(n>0){
            hanoi(n-1,A,C,B);
            move(n,A,C);
            hanoi(n-1,B,A,C);
        }
    }

    public static void move(int n,String A,String C){
        System.out.println(n+" from "+A+" to "+C);
    }
}
