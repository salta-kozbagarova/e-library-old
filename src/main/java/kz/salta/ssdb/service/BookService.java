package kz.salta.ssdb.service;

import java.util.List;

import kz.salta.ssdb.model.Book;

public interface BookService {
	
	List<Book> findAll();
	
	void takeBook(Long id);
	
	void returnBook(Long id);
	
	List<Book> booksToReturnForCurrentUser();
}
