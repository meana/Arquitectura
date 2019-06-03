package impl.miw.persistence.city;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.City;
import com.miw.persistence.CityDataService;

public class CityDAO implements CityDataService {
	
	private final String DB_DRIVER = "org.hsqldb.jdbcDriver";
	private final String DB_URL = "jdbc:hsqldb:hsql://localhost/amazin";
	private final String GET_CITIES_QUERY = "select * from cities";
	
	public Vector<City> getCities() throws Exception {
		
		Vector<City> resultado = new Vector<City>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = DB_DRIVER;
			String SQL_URL = DB_URL;

			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement(GET_CITIES_QUERY);
			rs = ps.executeQuery();

			while (rs.next()) {
				City city = new City();
				city.setId(rs.getInt("id"));
				city.setName(rs.getString("name"));
				resultado.add(city);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}

		return resultado;
	}

}
