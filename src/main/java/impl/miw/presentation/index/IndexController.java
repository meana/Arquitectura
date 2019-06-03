package impl.miw.presentation.index;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miw.business.CityManagerService;
import com.miw.model.City;
import com.miw.model.SearchCriteria;

import impl.miw.presentation.VisitCounter;

@Controller
@RequestMapping("index")
public class IndexController {
	
	private Boolean errors = false;
	
	@Autowired
	private CityManagerService cityMangerService;
	

	@RequestMapping (method = RequestMethod.GET)
	public String getForm(@ModelAttribute("visitCounter")
	VisitCounter counter)
	{
		counter.inc();
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute ("index") SearchCriteria searchCriteria, Model model, RedirectAttributes redirectAttributes) throws ParseException
	{
		System.out.println("Procesando el formulario");
		validateForm(searchCriteria, model);
		return null;
	}	
	
	@ModelAttribute("index")
	public SearchCriteria prepareModel(Model model) throws Exception
	{
		Vector<City> cities = cityMangerService.getCities();
		Map<Integer, String> citiesList = new HashMap<Integer, String>();
		cities.forEach(city -> {
			citiesList.put(city.getId(), city.getName());
		});
		model.addAttribute("cities", citiesList);
		return new SearchCriteria();
	}
	

	private Boolean validateForm(SearchCriteria searchCriteria, Model model) {
		System.out.println("Procesando el formulario");
		if(searchCriteria.getOriginId() == searchCriteria.getDestinationId()) {
			errors = true;
			model.addAttribute("errorCode", "OrigenDestidoIguales");
			return false;
		}
		return true;
	}

}
