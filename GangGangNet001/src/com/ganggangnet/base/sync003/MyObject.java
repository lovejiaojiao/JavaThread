package com.ganggangnet.base.sync003;

/**
 * 同步：synchronize
 *      同步的概念就是共享，我们要牢牢记住“共享”这两个字，如果不是共享资源，就没必要进行同步，
 *  异步：asynchronize
 *      异步的概念就是独立，相互之间不受任何制约，就好像我们学HTTP的时候，在页面发起ajax请求，我们还可以浏览或
 *      继续操作页面的内容，二者之间没有任何关系。
 *  同步的目的就是为了线程安全，其实对于线程安全来说，需要满足两个特性：
 *      原子性（同步）
 *      可见性
 *
 *   总结：
 * */

public class MyObject {

    public synchronized void method1(){
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void method2(){
        System.out.println("method2="+Thread.currentThread().getName());
    }

    public static void main(String args[]){
        final MyObject mo = new MyObject();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method1();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method2();
                //mo.method1();
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method2();
                //mo.method1();
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method2();
                //mo.method1();
            }
        });
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method2();
                //mo.method1();
            }
        });

        t1.start();
        t2.start();

        t3.start();
        t4.start();
        t5.start();
        t6.start();




    }

}
