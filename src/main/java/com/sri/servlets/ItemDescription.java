package com.sri.servlets;

import java.util.ArrayList;

public class ItemDescription {

	int barcode=0;
	String description=null;
	private static ItemDescription object=new ItemDescription();
	ArrayList<ItemDescription> list=new ArrayList<ItemDescription>();
	
	private ItemDescription() {
		
	}
	private ItemDescription(int barcode,String description) {
		this.barcode=barcode;
		this.description=description;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static ItemDescription getInstance() {
		return object;
	}
	
	public void display() {
		ItemDAO.descriptionDisplay();
	}
}
