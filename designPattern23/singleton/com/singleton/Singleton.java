package com.singleton;

public class Singleton {

	private static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (null == singleton) {
			synchronized (Singleton.class) {
				if (null == singleton) {
					singleton = new Singleton();
				}
			}
		}

		return singleton;
	}

}
