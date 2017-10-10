package com.sri.servlets;

public class Item 
{
private int barcode;
private String name;
private double price;
private int quantity;
public Item() {
	
}
public Item(String name,double price,int quantity)
{
	this.name=name;
	this.price=price;
	this.quantity=quantity;
	
}

public String getName() {
	return name;
}
public double getPrice() {
	return price;
}
public int getQuantity() {
	return quantity;
}
public int getBarcode() {
	return barcode;
}
public void setName(String name) {
	this.name=name;
}
public void setPrice(double price) {
	this.price=price;
}
public  void setQuantity(int quantity) {
	this.quantity=quantity;
}
public void setBarcode(int barcode) {
	this.barcode = barcode;
}
public int hashcode() {
	return Integer.parseInt(name)+(int)price+(int)quantity;
}
public boolean equals(Object obj) 
{
	boolean flag=false;
	Item itm=(Item)obj;
	if(itm.name==name) 
		flag=true;
	return flag;
}
}
