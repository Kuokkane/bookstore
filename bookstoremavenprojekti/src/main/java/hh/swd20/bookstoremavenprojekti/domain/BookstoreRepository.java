package hh.swd20.bookstoremavenprojekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hh.swd20.bookstoremavenprojekti.domain.Book;
public interface BookstoreRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByTitle(String title);

	




}
