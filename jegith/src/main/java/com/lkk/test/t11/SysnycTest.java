package com.lkk.test.t11;

import javax.swing.plaf.SliderUI;

public class SysnycTest {
	public  void get() throws InterruptedException {
		synchronized(this) {
			System.out.println("获得锁");
			System.out.println("get(): thead is :"+Thread.currentThread().getName());
			Thread.currentThread().sleep(1000);
			System.out.println("退出锁.");
		}
		
		
	}
	
	public synchronized void set() throws InterruptedException {
		System.out.println("获得锁");
		System.out.println("set(): thead is :"+Thread.currentThread().getName());
		Thread.currentThread().sleep(1000);
		System.out.println("退出锁.");
		
	}
	
	public static void main(String[] args) {
		SysnycTest test = new SysnycTest();
		Thread t1 = new Thread(()-> {
			try {
				test.set();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		t1.start();
		
		Thread t2 = new Thread(()-> {
			try {
				test.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t2.start();
	}

}
