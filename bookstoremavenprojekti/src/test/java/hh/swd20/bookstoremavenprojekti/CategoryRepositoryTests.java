package hh.swd20.bookstoremavenprojekti;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstoremavenprojekti.domain.Category;

import hh.swd20.bookstoremavenprojekti.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {
	
	
	 @Autowired
	    private CategoryRepository repository;

	    @Test
	    public void findByNameReturnId() {
	        List<Category>categories = repository.findByName("Adventure");
	        
	        assertThat(categories).hasSize(1);
	        assertThat(categories.get(0).getCategoryid()).isEqualTo(1L);
	    }
	    
	    @Test
	    public void createNewCategory() {
	    	Category category = new Category("Drama");
	    	repository.save(category);
	    	assertThat(category.getCategoryid()).isNotNull();
	    }   
	    	
	    }    

	

