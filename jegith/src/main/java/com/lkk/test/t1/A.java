package com.lkk.test.t1;

public class A {
	protected String str = "ss";
	
	{
		System.out.println("aaaaaa");
		
	}
	 
	
	static {
		System.out.println("static aaaaaaaaa");
	}
	 public A(){
		System.out.println("constrol A()");
	}
	
	public void func() {
		System.out.println("1111");
	}
	
	protected void func1() {
		System.out.println("1111");
	}

}
