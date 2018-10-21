package org.echocat.kata.java.part1;

public class Book extends Content{
	String description;
	
	public void printContent() {
		super.printContent();
		System.out.println("Description: "+this.description);
	}
}
