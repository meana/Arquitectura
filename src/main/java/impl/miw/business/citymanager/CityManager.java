package impl.miw.business.citymanager;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.CityManagerService;
import com.miw.model.City;
import com.miw.persistence.CityDataService;

public class CityManager implements CityManagerService {

	@Autowired
	private CityDataService cityDataService = null;
	
	public void setCityDataService(CityDataService cityDataService) {
		this.cityDataService = cityDataService;
	}
	
	public Vector<City> getCities() throws Exception {
		return cityDataService.getCities();
	}

}
