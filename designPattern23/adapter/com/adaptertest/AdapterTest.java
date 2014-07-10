package com.adaptertest;

import com.adaptee.Adaptee;
import com.adapter.Adapter;
import com.target.Target;

public class AdapterTest {

	public static void main(String[] args) {
		Target target = new Adapter(new Adaptee());
		
		target.adapteeMethod();
		target.adpterMethod();
	}

}
