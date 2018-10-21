package org.echocat.kata.java.part1;

import java.util.ArrayList;

public class Book extends Content{
	String description;
	
	Book(String title, String isbn, ArrayList<Author> authors, String description) {
		super.Content(title, isbn, authors);
		this.description = description;
	}
	
	public void printContent() {
		super.printContent();
		System.out.println("Description: "+this.description);
		System.out.println();
	}
}
