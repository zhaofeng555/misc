package hjg.mianshi;

	public class Outer {
	    public void someOuterMethod() {
	       // Line 3
	       new Inner();//放在这里不出错
	    }
	    public class Inner {
	    }
	 
	    public static void main(String[] argv) {
	       Outer o= new Outer();
	       o.new Inner();
	       // Line 8
	       //o不能够被解释成为一种类型，出错
//	       new o.Inner();
	       /**
	        *下面两种用法，都报下面的错误：
	        *NoenclosinginstanceoftypeOuterisaccessible.
	        *Mustqualifytheallocationwithanenclosinginstance
	        *oftypeOuter(e.g.x.newA()wherexisaninstanceofOuter)
	        */   
//	       new Outer.Inner();
//	       new Inner();      
	    }
}