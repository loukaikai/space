package com.lkk.test.t1;

public class Insideclass {
	
	private  Inclass  inclass= null;
	private int i = 99;
	static String str = "sss";
	static {
		System.out.println("static outclass");
	}
	public Insideclass() {
		
		System.out.println("Insideclass");
	}
	
	public void fff() {
		class jubuclass{
			private  jubuclass() {
				System.out.println("iiiiii"+i);

			}
		}
	}
	class Inclass{
		private int i = 100;
		String str = "sssssss";
		 
 
		public Inclass( ) {
			System.out.println("inclass");
			System.out.println("i:"+i++);
			System.out.println(str);
			
			System.out.println(Insideclass.str);
			System.out.println(Insideclass.this.i);
		}
		
	}
	
	public static void main(String[] args) {
		Insideclass insideclass = new Insideclass();
		Insideclass.Inclass inner = insideclass.new Inclass(); 
		 
	}

}
