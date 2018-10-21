package org.echocat.kata.java.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {
	
	static Scanner CSVFileScanner(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
        scanner.useDelimiter(";");
        scanner.nextLine(); //Ignores the first line
        return scanner;
	}
	
	static ArrayList<Author> ReadFileAsAuthors(String filename) throws FileNotFoundException {
		ArrayList<Author> list = new ArrayList<Author>();
		Scanner scanner = CSVFileScanner(filename);
		
		while(scanner.hasNext()){
			String content[] = scanner.nextLine().split(";");
			Author author = new Author(content[1], content[2], content[0]);
            author.printAuthor();
            list.add(author);
        }
        scanner.close();
        
        return list;        
	}
	
	private static Author FindAuthorByEmail(String string, ArrayList<Author> authorList) {
		int size = authorList.size();
		for(int i = 0; i < size; i++) {
			if(authorList.get(i).email.equals(string)) {
				return authorList.get(i);
			}
		}
		return null;
	}
	
	private static Content FindContentByIsbn(String isbn, ArrayList<Content> contentList) {
		int size = contentList.size();
		for(int i = 0; i < size; i++) {
			if(contentList.get(i).isbn.equals(isbn)) {
				return contentList.get(i);
			}
		}
		return null;
	}
	
	static void ReadFileAsContents(String filename, ArrayList<Author> authorList, boolean isMagazine, ArrayList<Content> list) throws FileNotFoundException {
		Scanner scanner = CSVFileScanner(filename);
		
		while(scanner.hasNext()){
			String content[] = scanner.nextLine().split(";");
			ArrayList<Author> authors = new ArrayList<Author>();
			String mailAuthors[] = content[2].split(",");
			
			for(int i = 0; i < mailAuthors.length; i++) {
				authors.add(FindAuthorByEmail(mailAuthors[i], authorList));
			}
			
			Content c = new Content();
			if(isMagazine) {
				c = new Magazine(content[0], content[1], authors, content[3]);
			}
			else {
				c = new Book(content[0], content[1], authors, content[3]);
			}
			c.printContent();
            list.add(c);
        }
        scanner.close();
	}

	
	static ArrayList<Content> ReadContents(String filenameMagazines, String filenameBooks, ArrayList<Author> authorList) throws FileNotFoundException {
		ArrayList<Content> list = new ArrayList<Content>();
		ReadFileAsContents(filenameMagazines, authorList, true, list);
		ReadFileAsContents(filenameBooks, authorList, false, list);
		return list;
	}
	
	static void printContentList(ArrayList<Content> contents) {
		int size = contents.size();
		for(int i = 0; i < size; i++) {
			contents.get(i);
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
    	String path = "src/main/resources/org/echocat/kata/java/part1/data/";
    	ArrayList<Author> authors = ReadFileAsAuthors(path+"authors.csv");
    	ArrayList<Content> contentList = ReadContents(path+"magazines.csv", path+"books.csv", authors);
 
    	printContentList(contentList);
    	
    	Content example1 = FindContentByIsbn("1024-5245-8584", contentList);
    	System.out.println("--- Article found with ISBN 1024-5245-8584 ---");
    	example1.printContent();
    }

}
