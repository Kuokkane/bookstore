package hh.swd20.bookstoremavenprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.swd20.bookstoremavenprojekti.domain.Book;
import hh.swd20.bookstoremavenprojekti.domain.BookstoreRepository;
import hh.swd20.bookstoremavenprojekti.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookstoreRepository repository;
	
	@Autowired
	private CategoryRepository crepository; 
	
	
	 @RequestMapping(value="/booklist")
	    public String bookList(Model model) {	
	    	model.addAttribute("books", repository.findAll());
	       
	    	
	    	return "booklist"; 
	    	
	    }
	 @RequestMapping(value = "/addbook")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categories", crepository.findAll());
	        return "addbook";
	    } 
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:booklist";
	    }   
	  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long id, Model model) {
	    	repository.deleteById(id);
	        return "redirect:../booklist";
	        
	   
	
	

	  }
	  
//	  @RequestMapping(value = "/save", method = RequestMethod.POST)
//	    public String save(Category category){
//	        crepository.save(category);
//	        return "redirect:categorylist";
//}
	  
}

