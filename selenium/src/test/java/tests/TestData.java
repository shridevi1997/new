package tests;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="dp1")
	public Object[][] validLoginData()
	{
		//3 rows & 2 columns -- Java Objects
		
		Object[][] obj= {	
							{"askmail@email.com","abc123"},
							{"askmail@ymail.com","abc123"},
							{"askmail@gmail.com","abc123"}
		};
		
		return obj;
	}

	@DataProvider(name="dp2")
	public Object[][] invalidLoginData()
	{
		//4 rows & 2 columns -- Java Objects
		
		Object[][] obj= {	
							{"askmail.com","abc1233232"},
							{"","abc123"},
							{"askmail@gmail.com",""},
							{"",""}
		};
		
		return obj;
	}
}
