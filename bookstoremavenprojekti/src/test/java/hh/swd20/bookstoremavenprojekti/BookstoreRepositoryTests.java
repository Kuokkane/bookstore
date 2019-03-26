package hh.swd20.bookstoremavenprojekti;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import hh.swd20.bookstoremavenprojekti.domain.Book;
import hh.swd20.bookstoremavenprojekti.domain.BookstoreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTests {

    @Autowired
    private BookstoreRepository repository;

    @Test
    public void findByTitleReturnId() {
        List<Book> books = repository.findByTitle("To catch a fish");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getId()).isEqualTo(1L);
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Test", "Testboy Tester", 12, null, 0, null);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}
