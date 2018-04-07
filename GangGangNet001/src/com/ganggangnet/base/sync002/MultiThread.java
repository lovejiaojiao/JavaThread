package com.ganggangnet.base.sync002;

/**
 * 一个对象有一个锁
 *
 *
 *
 * 1)如果在静态的方法上去加上static关键字修饰的话，那它以后获得的锁就是当前这个类级别的锁。
 * 无论实例化了多少个对象，都是没有任何关联关系
 *
 * 2)如果不在静态方法上不加static关键字修饰，那么得到的这个锁就不是类级别的锁，
 *
 * 类锁
 *
 * 总结：
 *      关键字synchronize取得的锁就是对象锁，而不是一段代码锁（方法）当做锁，所以以下代码中那个线程先执行synchronize关键字的方法
 *  那个线程就持有该方法所持对象的锁，（LOCK），两个对象，线程就是活动两个不同的锁，他们互不影响。
 *      有一种情况则是相同的锁，即在静态方法上家synchronize关键字，表示锁定.class类类一级别的锁（独占.class类）。
 * */

public class MultiThread  {
    //private int num = 0;
    private static int num = 0;

    //synchronized
    //static
    //public synchronized printNum(String tag){
    //public static printNum(String tag){
    public static synchronized void printNum(String tag){
        try{
            if(tag.equals("a")){
                num = 100;
                System.out.println("tag a,set num over!");
                Thread.sleep(1000);
            }else{
                num = 200;
                System.out.println("tag b,set num over!");
            }
            System.out.println("tag = "+tag+",tag = "+num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        MultiThread m1 = new MultiThread();
        MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}
