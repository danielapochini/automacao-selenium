import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test; 

public class TesteGoogle {
	 
	@Before
	public void inicializa(){
		getDriver(); 
	}
	
	@After
	public void finaliza(){
		killDriver();
	}
	
	@Test
	public void teste() {
		getDriver().get("http://www.google.com");
		Assert.assertEquals("Google", getDriver().getTitle()); 
	}

}
