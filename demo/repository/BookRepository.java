package com.adityaspring.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.adityaspring.demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
