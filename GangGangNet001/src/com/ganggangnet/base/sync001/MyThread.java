package com.ganggangnet.base.sync001;


/**
 *
 * 首先我们来谈线程安全的概念，当然了，这种概念很多前辈都说过，在学校老师说过，在工作中，带自己的师傅说过，可见这个线程安全在软件开发中的重要性。
 * 线程的概念莫非就是，当我们去访问一个类（对象和方法）时，为了保证多个线程同时访问和修改时始终能够保证输出正确的行为，那么这个类(对象和方法)就是线程安全的。
 *
 * */
public class MyThread extends Thread {
    private int count = 5;

    /**
     * 未用synchronize加锁的run方法
     * */
    /*public void run(){
        count--;
        System.out.println("Thread's name = "+this.currentThread().getName()+"  value = "+count);
    }*/

    /**
     * 使用用synchronize加锁的run方法
     * */
    public synchronized void run(){
        count--;
        System.out.println("Thread's name = "+this.currentThread().getName()+" value = "+count);
    }
    public static void main(String[] args){
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread,"t1");
        Thread t2 = new Thread(myThread,"t2");
        Thread t3 = new Thread(myThread,"t3");
        Thread t4 = new Thread(myThread,"t4");
        Thread t5 = new Thread(myThread,"t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
