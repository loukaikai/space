package com.lkk.jeight.moren;

public class C implements A,B{
	public void hello() {
		B.super.hello();
	}
	public static void main(String[] args) {
		new C().hello();
	}
}
