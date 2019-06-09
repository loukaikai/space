package com.lkk.test.t11;

public class OuterClass {
	String name = "11";
    public void display( String name,String age){
        class InnerClass{
            void display(){
                System.out.println(name);
            }
        }
    }
    public static void main(String[] args) {
    	OuterClass o = new OuterClass();
    	o.display("ss","dd");
	}
}
