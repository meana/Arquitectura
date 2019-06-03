package impl.miw.presentation.seekbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miw.business.BookManagerService;

@Controller
public class SeekBooksController {

	@Autowired
	private BookManagerService bookManagerService;
	
	public void setBookManagerService(BookManagerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}

	@RequestMapping("private/seekBooks")
	public String seekBooks(Model model) throws Exception {
		System.out.println("Executing SeekBooks.");

		// We store the list of books in teh model.
		model.addAttribute("booklist",
				bookManagerService.getBooks());
		// We return the name of the view. 
		return "private/seekBooks";
		
	}
}
