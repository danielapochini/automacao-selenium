package test;
import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest; 

public class TesteGoogle extends BaseTest{
	 
	@Before
	public void inicializa(){
		getDriver(); 
	}
 
	@Test
	public void teste() {
		getDriver().get("http://www.google.com");
		Assert.assertEquals("Google", getDriver().getTitle()); 
	}

}
