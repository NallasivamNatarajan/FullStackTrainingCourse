package com.stream.example;

public interface ClassD {
	void method();
	
	default void  print() {
		System.out.println("Interface D");
	}

}
