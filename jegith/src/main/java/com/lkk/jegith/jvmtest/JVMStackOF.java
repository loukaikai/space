package com.lkk.jegith.jvmtest;


/**
 * JVM Args:-Xss:128K
 * **/
public class JVMStackOF {
		private int stackLength = 1;
		public void stackfun() {
			stackLength++;
			stackfun();
		}
		
		public static void main(String[] args) {
			JVMStackOF oom = new JVMStackOF();
			oom.stackfun();
		}
	
}
