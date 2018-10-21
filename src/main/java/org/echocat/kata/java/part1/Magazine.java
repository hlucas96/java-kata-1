package org.echocat.kata.java.part1;

import java.util.ArrayList;

public class Magazine extends Content{
	String publishedAt;
	
	Magazine(String title, String isbn, ArrayList<Author> authors, String publishedAt) {
		super.Content(title, isbn, authors);
		this.publishedAt = publishedAt;
	}
	
	public void printContent() {
		super.printContent();
		System.out.println("Published at: "+this.publishedAt);
		System.out.println();
	}
}
