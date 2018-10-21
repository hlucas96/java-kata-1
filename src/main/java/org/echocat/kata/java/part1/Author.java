package org.echocat.kata.java.part1;

public class Author {
	String firstname;
	String lastname;
	String email;
	
	public Author(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public void printAuthor() {
		System.out.println("AUTHOR\n"+this.firstname+" "+this.lastname+"\nEmail: "+this.email);
	}
	public void printMinAuthor() {
		System.out.println(this.firstname+" "+this.lastname);
	}
}
