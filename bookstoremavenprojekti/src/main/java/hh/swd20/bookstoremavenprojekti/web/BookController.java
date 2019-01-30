package hh.swd20.bookstoremavenprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.swd20.bookstoremavenprojekti.domain.*;

@Controller
public class BookController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String newBook (Model model)  {
		
		Book book = new Book();
		
		model.addAttribute("book", book);
		return "showbooks";
		
		
	}
	
	
	



}
