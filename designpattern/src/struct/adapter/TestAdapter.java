package struct.adapter;

import struct.adapter.adaptee.Adaptee;
import struct.adapter.target.Adapter;
import struct.adapter.target.Target;


public class TestAdapter {

	public static void main(String[] args) {
		Target target = new Adapter(new Adaptee());
		target.adapteeMethod();
		target.adapterMethod();
	}

}
