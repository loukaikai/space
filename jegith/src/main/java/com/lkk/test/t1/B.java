package com.lkk.test.t1;

class D{
	protected String str = "ss";
	public void funca() {
		A a = new A();
		a.str = "";
		a.func1();
	}
}
public class B extends D{
	private static String aa = "sss";
	B(){
		System.out.println(str);
	}
	public static void main(String[] args) {
		A a = new A();
		String as= a.str;
		a.func();
		a.func1();
		
		String f = "ssss";
//		 double i = (double)f;
//		 System.out.println(i);
	}

}
