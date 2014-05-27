package com.principle.lsp;

class A{
    public int func1(int a, int b){
       return a-b;
    }
}
class B extends A{
    public int func1(int a, int b){
       return a+b;
    }
   
    public int func2(int a, int b){
       return func1(a,b)+100;
    }
}
public class Client{
    public static void main(String[] args){
       ATest();
       BTest();
    }

	private static void ATest() {
		A a = new A();
		   System.out.println("100-50="+a.func1(100, 50));
		   System.out.println("100-80="+a.func1(100, 80));
	}
	private static void BTest() {
	       B b = new B();
	       System.out.println("100-50="+b.func1(100, 50));
	       System.out.println("100-80="+b.func1(100, 80));
	       System.out.println("100+20+100="+b.func2(100, 20));
	    }
}