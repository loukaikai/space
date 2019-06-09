package com.lkk.test.t11;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import com.lkk.test.t1.A;

class E extends A{
	
	A aa = new A();
	public void aa() {
		A a = new A();
		a.func();
		super.func1();
		super.str = "";
		 int i = 100;
	
	}
	 
}

public class C extends A{
	static int i = 0;
	int j = 0;
	{
		System.out.println("ccccccc");
		
	}
	 
	
	static {
		System.out.println("static ccccccccc");
	}
	C(){
//		super();
		System.out.println("constrol c()");
	}
	public void aa() {
		A a = new A();
		a.func();
		
	
	}
	private NonameInstaic aaa(String k,int h,int i,A aa) {
		return new NonameInstaic() {
			private void sysout() {
				System.out.println(k+j+i+aa);
			}
		};
	}
	private void  staticname(NonameInstaic name) {
		System.out.println("name:"+name.getName());
	}
	public static void main(String[] args) {
		/*A a = new A();
		a.func();
		a.func();
		a.*/
		
		/*		for(int i =0;i<10;i++ ) {
			C c = new C();
			c.i++;
			c.j++;
			System.out.println(c.i);
			System.out.println(c.j);
		}*/
	/*	Random ran = new Random(47);
		Integer [] ing = new Integer[ran.nextInt(20)];
		System.out.println("Integer : "+Arrays.toString(ing));
		System.out.println("Integer : "+ing[1]++);*/
		System.out.println("main()");
		new C().staticname(new NonameInstaic() {
			 public void setName(String name) {
				 name = "ddddddddddd";
			 }
		});;
		 
		
	}

}
