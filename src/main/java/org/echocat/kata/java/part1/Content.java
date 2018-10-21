package org.echocat.kata.java.part1;

import java.util.ArrayList;

public class Content {
	String title;
	String isbn;
	ArrayList<Author> authors;
	
	void Content(String title, String isbn, ArrayList<Author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}
	
	public void printContent() {
		System.out.println(this.title +"\n"
				+ "ISBN: " + this.isbn);
		System.out.print("Authors: ");
		for(int i = 0; i < this.authors.size(); i++) {
			authors.get(i).printMinAuthor();
			if(i != this.authors.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
}
