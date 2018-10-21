package org.echocat.kata.java.part1;

public class Magazine extends Content{
	String publishedAt;
	
	public void printContent() {
		super.printContent();
		System.out.println("Published at: "+this.publishedAt);
	}
}
