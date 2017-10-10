package com.sri.servlets;

public class descriptionMain {

	public static void main(String[] args) {
		ItemDescription obj=ItemDescription.getInstance();
		obj.display();
		System.out.println(obj);
		ItemDescription obj1=ItemDescription.getInstance();
		obj1.display();
		System.out.println(obj1);
	}

}
