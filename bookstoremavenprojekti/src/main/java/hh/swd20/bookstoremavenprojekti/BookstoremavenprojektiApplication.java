package hh.swd20.bookstoremavenprojekti;

import org.springframework.boot.CommandLineRunner;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstoremavenprojekti.domain.Book;
import hh.swd20.bookstoremavenprojekti.domain.BookstoreRepository;
import hh.swd20.bookstoremavenprojekti.domain.Category;
import hh.swd20.bookstoremavenprojekti.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class BookstoremavenprojektiApplication {
private static final Logger log = LoggerFactory.getLogger(BookstoremavenprojektiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoremavenprojektiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookstoreRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("saved books");
			Category adventure = new Category ("Adventure"); 
			crepository.save (adventure);
			Category survival = new Category ("Survival");
			crepository.save(survival);
			
			crepository.save(new Category("Scifi"));
			repository.save(new Book ("Jimmy's BIG adventure", "Johnnyboy Johnson", 2019, "J-33-J33", 10.00, adventure));
			repository.save(new Book ("To catch a fish", "Felix McFisherman", 1999, "F-1-5-H-1-N-G", 20.00, survival));
			
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

