package com.lkk.jegith.current.ProdectandCoument;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdectandCoument {
	private  LinkedList<Dataproduct> queue = new LinkedList<Dataproduct>();
	final static int MAX = 10;
	Lock lock = new ReentrantLock();
	Condition lockproduct = lock.newCondition();
	Condition lockclo = lock.newCondition();
	
	
	//生产者
	public void put(Dataproduct data) {
		try {
			lock.lock();
			while(queue.size() == MAX) {
				lockproduct.await();
			}
			queue.add(data);
 			lockclo.signalAll();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
 


	//消费者
	public Dataproduct get() {
		Dataproduct data = null;
		
		try {
			lock.lock();
			while(queue.size() == 0) {
				lockclo.await();
			}
			
		   data = queue.removeFirst();
			
		   lockproduct.signalAll();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		return data;
	}
	
	public static void main(String[] args) {
		ProdectandCoument pac = new ProdectandCoument();
	 
		new Thread(() -> {
			pac.put(new Dataproduct());
			System.out.println("生产者 添加数据  queue长度: "+pac.queue.size());
		}).start()  ;
		
		try {
			TimeUnit.SECONDS.sleep(12);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(() -> {
			Dataproduct data = pac.get();
			System.out.println("消费者 添加数据    queue长度 : "+pac.queue.size()+ "数据为"+data);
		}).start() ;
		
	}
	

}

class Dataproduct{
	public static volatile int i = 0;
	public Dataproduct() {
		i++;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Dataproduct:" +i;
	}
}


