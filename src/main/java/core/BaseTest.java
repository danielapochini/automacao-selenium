package core;

import static core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest {

	@After
	public void finaliza(){
		killDriver();
	}
}
