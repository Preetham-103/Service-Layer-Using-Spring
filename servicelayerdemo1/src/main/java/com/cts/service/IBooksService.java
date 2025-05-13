package com.cts.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.entity.Books;

public interface IBooksService {
	Books addBooks(Books books);

	Books getBooksById(int id);

	List<Books> getallBooks();

	Books updateBooks(@PathVariable int id);

	String deleteBooksById(int id);
}
