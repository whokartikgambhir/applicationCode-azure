package com.springRest.SpringRest.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.SpringRest.entities.Book;
import com.springRest.SpringRest.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	ArrayList<Book> list;
	@Autowired
	private BookRepository bookRepository;

	long millis = System.currentTimeMillis();
	java.sql.Date date = new java.sql.Date(millis);

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public BookServiceImpl() {
	}

	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> list = (ArrayList<Book>) bookRepository.findAll();
		Collections.sort(list);
		return list;
	}

	@Override
	public Book getBook(long book_code) {
		Optional<Book> optional = bookRepository.findById(book_code);
		Book book = null;
		if(optional.isPresent()) {
			book = optional.get();
		}
		else {
			throw new RuntimeException("Book not founf by code : " + book_code);
		}
		
		
		
		Book bk = bookRepository.getOne(book_code);
		return book;
	}


	@Override
	public void saveBook(Book book) {
		/*
		 * ArrayList<Book> list = (ArrayList<Book>)bookRepository.findAll(); for(Book x:
		 * list) { if(x.getBook_code() == book.getBook_code()) {
		 * 
		 * } }
		 */
		System.out.println(StringUtils.capitalize("apache commons"));
		book.setBook_name(StringUtils.capitalize(book.getBook_name()));
		
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(long book_code) {
		Book bk = bookRepository.getOne(book_code);
		bookRepository.delete(bk);
	}

//	@Override
//	public Book addBook(Book book) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
