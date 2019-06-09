package com.lkk.jeight.moren;

public class AppTest {
	public static void main(String[] args) {
		Monster m = new Monster();
		m.setRotationAngle(360001);
		System.out.println(m.getX());
		m.rotateBy(36000001);
		System.out.println(m.getRotationAngle());
	}
}
