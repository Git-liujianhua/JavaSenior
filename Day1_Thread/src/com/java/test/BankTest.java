package com.java.test;

//单例模式
//懒汉式代码解决加入synchronized。
//此代码为懒汉式
public class BankTest {

}
class Bank{
    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance() {

        //效率低
//        synchronized (Bank.class) {
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }


}
