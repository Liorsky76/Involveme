package test;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pageObject.MainPage;

public class MainPageTest extends BaseTest {

	@Test(description = "Check if the https://www.shichor.co.il site is loaded")
	public void tc01_loadTheSite() {
		MainPage mainpage = new MainPage(driver);
		boolean actualstatus = mainpage.isLogoMainPageEnable();
		assertTrue(actualstatus);
	}

	@Test(description = "Click on Destinations ")
	public void tc02_checkDestination() {
		MainPage mainpage = new MainPage(driver);
		mainpage.clickOnDestinations();
		boolean actualstatus = mainpage.isDestinationsComboBoxEnable();
		assertTrue(actualstatus);

	}

	@Test(description = "Fill the required destination")
	public void tc03_fillDestination() {
		MainPage mainpage = new MainPage(driver);
		mainpage.setDestinationName("Italy");
		boolean actualstatus = mainpage.isDestinationsComboBoxEnable();
		assertTrue(actualstatus);
	}

	@Test(description = "click on search destination button")
	public void tc04_clickOnDestinationSearcButton() {
		MainPage mainpage = new MainPage(driver);
		mainpage.clickOnDestinationSearchBtn();
		boolean actualstatus = mainpage.isCountryFoundSearch("italy");
		assertTrue(actualstatus);

	}

	@Test(description = "set the destination which doesn't exist")
	public void tc05_setDestinationNameDoes_not_Exist() {
		MainPage mainpage = new MainPage(driver);
		mainpage.setDestinationName("kkkkkkkkk");
		mainpage.clickOnSearchTextField();
		boolean actualstatus = mainpage.destinationsNotFound();
		assertTrue(actualstatus);
	}

	@Test(description = "set the destination which doesn't exist")
	public void tc06_clickOnDestinationSearchBtn() {
		MainPage mainpage = new MainPage(driver);
		mainpage.clickOnDestinationSearchBtn();
		boolean actualstatus = mainpage.destinationsNotFound2();
		assertTrue(actualstatus);
	}

	@Test(description = "click on destinations")
	public void tc07_clickOnDestinations() {
		MainPage mainpage = new MainPage(driver);
		mainpage.clickOnDestinations();
		boolean actualstatus = mainpage.checkifTheSearchFieldIsEmpty();
		assertTrue(actualstatus);
	}

	@Test(description = "click on signIN")
	public void tc08_clickOnSignIn() {
		MainPage mainpage = new MainPage(driver);
		mainpage.clickOnSignIn();
		boolean actualstatus = mainpage.isSignInWindowEnable();
		assertTrue(actualstatus);
	}

	@Test(description = "Set Email and Password")
	public void tc09_SetEmailPassword() {
		MainPage mainpage = new MainPage(driver);
		mainpage.setLoginEmail("lior.razumovsky@stratasys.com");
		mainpage.setLoginPassword("MyGym2021");
		mainpage.clickOnLoginBtn();
		boolean actualstatus = mainpage.isProfileEnabled();
		assertTrue(actualstatus);
	}

	@Test(description = "click on Logout")
	public void tc10_clickOnLogout() {
		MainPage mainpage = new MainPage(driver);
		mainpage.clickOnMainProfile();
		mainpage.clickOnLogout();
		mainpage.clickOnLogoutBTN();
		boolean actualstatus = mainpage.isSignInEnable();
		assertTrue(actualstatus);
	}
}