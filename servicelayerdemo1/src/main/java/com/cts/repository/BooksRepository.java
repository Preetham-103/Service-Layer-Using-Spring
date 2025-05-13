package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.Books;
//@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{

}
