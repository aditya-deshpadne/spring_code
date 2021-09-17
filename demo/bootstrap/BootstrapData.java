package com.adityaspring.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adityaspring.demo.domain.Author;
import com.adityaspring.demo.domain.Book;
import com.adityaspring.demo.domain.Publisher;
import com.adityaspring.demo.repository.AuthorRepository;
import com.adityaspring.demo.repository.BookRepository;
import com.adityaspring.demo.repository.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		

		Publisher publisher = new Publisher("Safari", "Pune","Pune", "Mharashtra", "411004");
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("design driven developemnt", "123123");
				
		eric.getBooks().add(ddd);
		
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisher);
		
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		

		Author rod = new Author("rod", "Johnson");
		Book noEJB = new Book("j2EE Development without EJB", "111222");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
			
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);

		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count());
		System.out.println("Publishers of Books: " + publisher.getBooks().size());

	}

}
