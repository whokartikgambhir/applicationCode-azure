package com.springRest.SpringRest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springRest.SpringRest.entities.Book;
import com.springRest.SpringRest.services.BookService;

@Controller
public class MyController {
	@Autowired
	private BookService bookService;
	
	
	
	@GetMapping("/")
	public String getBooks(Model model){

		model.addAttribute("listBooks", bookService.getBooks());
		return "index";
		
	}
	

	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}
	
	
	@GetMapping("/books/{book_code}")
	public Book getBook(@PathVariable String book_code) {
		return bookService.getBook(Long.parseLong(book_code));
	}
	
	@PostMapping("/saveBook")
	public String addBook(@ModelAttribute ("book") Book book) {
		
		bookService.saveBook(book);
		
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{book_code}")
	public String showFormForUpdate(@PathVariable(value = "book_code") long book_code , Model model) {
		
		Book book = bookService.getBook(book_code);
		model.addAttribute("book" , book);
		return "update_book";
	}
	
	@GetMapping(path = "/deleteBook/{book_code}")
	public String deleteBook(@PathVariable("book_code") int book_code) {
		bookService.deleteBook(book_code); 
		return "redirect:/";
		
	}
	
}

