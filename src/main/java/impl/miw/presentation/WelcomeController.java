package impl.miw.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({ "visitCounter" })
@Controller
public class WelcomeController {

	/*
	 * Setting / as request mapping url we are setting the default controller for
	 * the application.
	 */
	@RequestMapping("/")
	public String welcome() {
		System.out.println("Executing Welcome controller");
		return "redirect:/index";
	}

	@ModelAttribute("visitCounter")
	public VisitCounter getLoginCounter() {
		System.out.println("Initializing visitCounter");
		return new VisitCounter();
	}

	@RequestMapping("loginError")
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login_page";
	}
}
