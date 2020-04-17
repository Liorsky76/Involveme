package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObject.MainPage;
import pageObject.ValidLoginPage;

public class ValidLoginTest extends BaseTest {

	@Test(description = "Set valid credentials ")
	public void project_page_01() {
		ValidLoginPage validloginpage = new ValidLoginPage(driver);
		MainPage mainpage = new MainPage(driver);
		validloginpage.login("LiorskyKr@gmail.com", "12345678");
		validloginpage.clickOnLoginSubmit();
		boolean expectedflag=true;
		boolean actualflag=mainpage.returnIfTheLinkIsEnabled();
		assertEquals(actualflag, expectedflag);
	}
}
