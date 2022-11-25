package com.springRest.SpringRest.services;

import java.util.ArrayList;

import com.springRest.SpringRest.entities.Book;

public interface BookService {
	public ArrayList<Book> getBooks();
	
	public Book getBook(long book_code);
	
	public void saveBook(Book book);
	
	public void deleteBook(long book_code);
	
}
