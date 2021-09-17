package com.adityaspring.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.adityaspring.demo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
