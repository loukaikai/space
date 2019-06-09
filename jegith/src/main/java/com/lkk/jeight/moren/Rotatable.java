package com.lkk.jeight.moren;

public interface Rotatable {
	void setRotationAngle(int angleInDegrees);
	int getRotationAngle();
	
	default void rotateBy(int angleInDegrees){
		System.out.println("使用default方法");
		int x = getRotationAngle ();
		System.out.println("getRotationAngle (): "+x);
		System.out.println("angleInDegrees: "+angleInDegrees);
		setRotationAngle((getRotationAngle () + angleInDegrees) % 360);
	}
}
