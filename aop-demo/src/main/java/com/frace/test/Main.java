package com.frace.test;

public class Main {

    int i=1;

    public int doSomething(int i){
        i=i+2;
        return i;
    }

    public static void main(String[] args) {
        int i=2;
        Main o=new Main();
        o.doSomething(i);//局部变量在方法结束的时候也被销毁
        System.out.println(i);//


    }
}
