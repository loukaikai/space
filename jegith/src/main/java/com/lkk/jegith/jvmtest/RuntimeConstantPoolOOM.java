package com.lkk.jegith.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10m -XX:MaxPermSize:10m
 * **/
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i = 1;
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
