package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.InvalidLoginPage;

public class InvalidLoginTest extends BaseTest {

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "LiorskyKr@gmail.com", "1234567" }, { "iorskyKr@gmail.com", "12345678" },
				{ "LiorskyKr@gmail.co", "12345678" }, { "lrazumovsky@Kramerel.com", "Lr123456789" },
				{ "LiorskyKr@gmail.com", "123456789" }, { "liorskykr1@gmail.com", "12345678" }, };
		return data;
	}

	@Test(dataProvider = "getData", description = "Try login using incorect email or password,verify correct error message appears")
	public void loginPage_01(String email, String password) {
		InvalidLoginPage loginpage = new InvalidLoginPage(driver);
		loginpage.login(email, password);
		loginpage.clickOnLoginSubmit();
		String actuallererormessage = "These credentials do not match our records.";
		String expStringError = loginpage.returnErrorLoginMessage();
		assertEquals(actuallererormessage, expStringError);
	}

	@Test(dataProvider = "getData", description = "Try login using incorrect email or password,verify that login button is enabled")
	public void login_page_02(String email, String password) {
		InvalidLoginPage loginpage = new InvalidLoginPage(driver);
		loginpage.login(email, password);
		loginpage.clickOnLoginSubmit();
		boolean actualflag = loginpage.retutnLoginBtnIfVissible();
		boolean expectedflag = true;
		assertEquals(actualflag, expectedflag);
	}

}
