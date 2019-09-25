package org.manage.im;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Channel
//    	ByteBufProcessor
        System.out.println( "Hello World!" );
        
        A a = new B();
        a.foo();
        		
    }
}

class A{
	public void foo() {
		System.out.println("11");
	}
}

class B extends A{
	public void foo() {
		System.out.println("11");
	}
}
