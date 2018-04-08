package com.ganggangnet.base.sync005;


/**
 *synchronized异常
 *
 * 在多线程当中，被线程调用的方法如果使用中断异常（InterruptedException）的话，当抛出异常时，则线程终止，使用（Exception）的话，
 * 即使抛出异常也会继续执行后面的业务
 *
 * */

public class SyncException {
    private int i = 0;
    public   void operation() {
        while (true){
            try{
                i++;
                //Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+" , i = " +i);
                if (i==20){
                    //抛出异常
                    //Integer.parseInt("a");
                    throw new RuntimeException();
                }
            //}catch (InterruptedException e){
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        final SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.operation();
            }
        },"t1");
        t1.start();
    }
}
