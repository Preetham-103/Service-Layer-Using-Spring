package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.cts.Springrestdemo1Application;
import com.cts.entity.Books;
import com.cts.repository.BooksRepository;

@RestController
@RequestMapping("/books")
public class BooksController {



	@Autowired
	private BooksRepository booksRepository;


	@PostMapping("/addbook")
	public Books addBooks(@RequestBody Books books) {
		return booksRepository.save(books);
	}

	@GetMapping("/getbooks/{id}")
	public Books getBooksById(@PathVariable int id) {
		Optional<Books> optionalBooks = booksRepository.findById(id);

		if (optionalBooks.isEmpty()) {
			throw new IllegalArgumentException("No book found");
		}

		return optionalBooks.get();
	}

	@GetMapping("/getall")
	public List<Books> getallBooks() {
		return booksRepository.findAll();
	}

	@PutMapping("/updatebooks/{id}")
	public Books updateBooks(@PathVariable int id, @RequestBody Books books) {
		Optional<Books> optionalBooks = booksRepository.findById(id);

		if (optionalBooks.isEmpty()) {
			throw new IllegalArgumentException("No books found");
		}

		Books updatedBooks = optionalBooks.get();

		updatedBooks.setTitle(books.getTitle());
		updatedBooks.setDescription(books.getDescription());
		updatedBooks.setPublisher(books.getPublisher());
		updatedBooks.setPrice(books.getPrice());
		return booksRepository.save(updatedBooks);
	}

	@DeleteMapping("/deletebooks/{id}")
	public String deleteBooksById(@PathVariable int id) {
		Optional<Books> optionalBooks = booksRepository.findById(id);

		if (optionalBooks.isEmpty()) {
			throw new IllegalArgumentException("No books found");
		}
		booksRepository.deleteById(id);
		return "Employee deleted Successfully";
	}
}
