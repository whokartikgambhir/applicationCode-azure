package com.springRest.SpringRest.entities;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book implements Comparable<Book> 
{
	@Id
	@Column(name = "book_code" , nullable = false)
	private long book_code;
	
	@Column(name = "book_name" , nullable = false)
	private String book_name;
	
	@Column(name = "auth_name" , nullable = false)
	private String auth_name;
	
	@Column(name = "date" , nullable = false)
	private String date = null;
	
	
	public Book(long book_code, String book_name, String auth_name, String date) {
		super();
		this.book_code = book_code;
		this.book_name = book_name;
		this.auth_name = auth_name;
		this.date = date;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getBook_code() {
		return book_code;
	}
	public void setBook_code(long book_code) {
		this.book_code = book_code;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuth_name() {
		return auth_name;
	}
	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Book [book_code=" + book_code + ", book_name=" + book_name + ", auth_name=" + auth_name + ", date="
				+ date + "]";
	}
	@Override
	public int compareTo(Book o) {
		int cmp = this.getBook_name().compareTo(o.getBook_name());
		return cmp != 0 ? cmp : this.getBook_name().compareTo(o.getBook_name());
	}

}
