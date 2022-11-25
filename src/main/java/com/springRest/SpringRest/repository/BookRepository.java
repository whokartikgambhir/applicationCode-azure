package com.springRest.SpringRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.SpringRest.entities.Book;

public interface BookRepository extends JpaRepository<Book , Long> {

}
