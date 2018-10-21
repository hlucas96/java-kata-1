package org.echocat.kata.java.part1;

import java.util.ArrayList;

public class Content {
	String title;
	String isbn;
	ArrayList<Author> authors;
	
	public void printContent() {
		System.out.println(this.title +"\n"
				+ "ISBN: " + this.isbn
				+ "Authors: ");
		for(int i = 0; i < this.authors.size(); i++) {
			authors.get(i).printMinAuthor();
		}
	}
	
}
