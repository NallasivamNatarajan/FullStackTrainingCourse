package com.stream.example;

public class ClassC implements ClassA,ClassB{

	
	public static void main(String[] args) {
	ClassC c = new ClassC();
	c.print();
	}

	@Override
	public void print() {
		ClassA.super.print();
		ClassB.super.print();
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}

	






}
