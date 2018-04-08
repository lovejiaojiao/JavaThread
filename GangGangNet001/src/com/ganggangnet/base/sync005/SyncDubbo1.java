package com.ganggangnet.base.sync005;

/**
 * synchronized的锁重入
 * @author Abrams
 *
 * reentranLock
 *
 * */

public class SyncDubbo1 {


    public synchronized void method1(){
        System.out.println("method1.."+Thread.currentThread().getName());
        method2();
    }

    public synchronized void method2(){
        System.out.println("method2.."+Thread.currentThread().getName());
        method3();
    }

    public synchronized void method3(){
        System.out.println("method3.."+Thread.currentThread().getName());
    }

    public static void main(String args[]){
        final SyncDubbo1 sd = new SyncDubbo1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sd.method1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sd.method1();
            }
        });

        t1.start();
        t2.start();
    }
}
