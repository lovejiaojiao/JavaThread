# JavaThread
java多行程，涨薪标准配置

# 谈java多线程
  谈Java多线程之前首先我们来谈线程安全的概念，当然了，这种概念很多前辈都说过，在学校老师说过，在工作中，带自己的师傅说过，可见这个线程安全在软件开发中的重要性。
  线程的概念莫非就是，当我们去访问一个类（对象和方法）时，为了保证多个线程同时访问和修改时始终能够保证输出正确的行为，那么这个类(对象和方法)就是线程安全的。这种说是比较专业性的话，下面我说一个我们看见的场景：
  1,当多个线程访问一个类时，他们就像是那些电影里面不排队的难民一样，一拥而上去抢粥喝，有的抢到了，有的没抢到。这种不加限制的的操作在软件工程里面的有些场景会带来非常严重的后果，比如说就像现在滴滴打车，如果有多个车主同时去接乘客的单子，这种场景不加控制的话，就会出现可能几个人同时接到这个单的这种风险，最终造成司机和乘客之间的不愉快，严重的直接就导致了公司无法运营下去，导致失业等等一系列的问题，可见，多线程在软件工程当中的重要性。
  
  
 # 代码如下
  
  package com.ganggangnet.base.sync001;

/**
 * 
 * 首先我们来谈线程安全的概念，当然了，这种概念很多前辈都说过，在学校老师说过，在工作中，带自己的师傅说过，可见这个线程安全在软件开发中的重要性。
 * 线程的概念莫非就是，当我们去访问一个类（对象和方法）时，为了保证多个线程同时访问和修改时始终能够保证输出正确的行为，那么这个类(对象和方法)就是线程安全的。
 * 
 * */

public class MyThread extends Thread{
	
	private int count = 5;
	
	/**
	 * 未用synchronize加锁的run方法
	 * */
	/*public  void run() {
		count--;
		System.out.println(this.currentThread().getName()+"count = "+count);
	}*/
	
	
	/**
	 * 使用用synchronize加锁的run方法
	 * */
	public synchronized void run() {
		count--;
		System.out.println(this.currentThread().getName()+"count = "+count);
	}
	
	public static void main(String[] args) {
		
		/**
		 * 分析：1,当多个线程访问没有经synchronized修饰的run方法是，他们就像是那些电影里面不排队的难民一样，一拥而上去抢粥喝，
		 * 有的抢到了，有的没抢到。这种不加限制的的操作在软件工程里面的有些场景会带来非常严重的后果，比如说就像现在滴滴打车，如果有多个车主同时去
		 * 接乘客的单子，这种场景不加控制的话，就会出现可能几个人同时接到这个单的这种风险，最终造成司机和乘客之间的不愉快，验证的直接就导致了公司无法运营下去
		 * 导致失业等等一系列的问题，可见，多线程在软件工程当中的重要性。
		 * 
		 * 以上是我个人之言，当然，理还是这个理。
		 * 		2,当我们给run方法添加synchronize修饰后，就相当于给凌乱不堪的难民们上了课，要求他们有次序的去食物，上一个人取到了，再到下一个，按需分配。
		 * 在多线程中，这种排队是由CPU分配的先后次序决定的。
		 * 
		 * 一个线程尝试要执行synchronize修饰的方法的代码：
		 * 	1）尝试获得锁。
		 * 	2）如果拿到锁执行synchronize代码体内容：拿不定锁，这个线程就会不断的尝试去获得这个锁，直到拿到为止，而且是多个线同时竞争这把锁
		 * 		
		 * 
		 * */
		
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
