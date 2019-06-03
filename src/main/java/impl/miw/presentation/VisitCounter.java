package impl.miw.presentation;

public class VisitCounter {

	private Integer logins;

	public Integer getLogins() {
		return logins;
	}
	
	public void inc()
	{
		logins ++;
	}
	
	public VisitCounter()
	{
		System.out.println("Inicializando el contador");
		logins=0;
	}
}
