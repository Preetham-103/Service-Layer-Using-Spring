package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Books;
import com.cts.repository.BooksRepository;

@Service
public class BooksService implements IBooksService {

	@Autowired
	BooksRepository booksRepository;

	@Override
	public Books addBooks(Books books) {
		if(books.getPrice()>100000)
		{
			throw new IllegalArgumentException("Expensive");
		}
		return booksRepository.save(books);
	}

	@Override
	public Books getBooksById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> getallBooks() {
		return booksRepository.findAll();
	}

	@Override
	public Books updateBooks(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBooksById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
