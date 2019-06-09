package com.lkk.jeight.moren;

public class Monster implements Rotatable, Moveable, Resizable{
	
	int angleInDegrees = 0;

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAbsoluteSize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotationAngle(int angleInDegrees) {
		this.angleInDegrees = angleInDegrees;
		
	}

	@Override
	public int getRotationAngle() {
		// TODO Auto-generated method stub
		return angleInDegrees;
	}

}
