package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
	@FindBy(css = "#__next > div.app-header-wrapper > header > div > a > img")
	private WebElement logoShichor;
	@FindBy(css = "#__next > main > div.destinations-header.img-bg.position-relative > form > div > div.form-control.col-12.col-sm > div > div > input")
	private WebElement destinationsComboBox;
	@FindBy(css = ".form-input__input.react-autosuggest__input.destinations-header__input")
	private WebElement searchDestinationsField;
	@FindBy(css = ".btn-secondary.destinations-header__btn.btn")
	private WebElement searchDestinationBtn;
	@FindBy(css = ".destinations-page-item__title.font-weight-medium")
	private WebElement countryDestinationFound;
	@FindBy(css = "#react-autowhatever-1")
	private WebElement DestinationNotFound;
	@FindBy(css = "#react-autowhatever-1")
	private WebElement distinationsNotFound;
	@FindBy(css = ".text-center.destinations-page__no-results ")
	private WebElement SorryWeCanNotFoundStr;
	@FindBy(css = "#__next > div.app-header-wrapper > header > div > div > nav > a:nth-child(1)")
	private WebElement Destinations;
	@FindBy(css = "#__next > div.app-header-wrapper > header > div > div > nav > button")
	private WebElement SignIn;
	@FindBy(css = "#email")
	private WebElement Email;
	@FindBy(css = "#password")
	private WebElement Password;
	@FindBy(css = ".btn-secondary.btn-fluid.form-submit.btn")
	private WebElement LoginBtn;
	@FindBy(css = "#__next > div.app-header-wrapper > header > div > div > nav > div")
	private WebElement MainProfile;
	@FindBy(css = "#__next > header > div > div > nav > div > div > a:nth-child(1)")
	private WebElement Profile;
	@FindBy(css = "#__next > div.app-header-wrapper > header > div > div > nav > div > div > button")
	private WebElement Logout;
	@FindBy(css = ".btn.btn-secondary.btn-small.btn")
	private WebElement LogoutBTN;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnDestinationSearchBtn() {
		click(searchDestinationBtn);
		sleep(2000);
	}

	public void clickOnMainProfile() {
		sleep(2000);
		click(MainProfile);
	}

	public void clickOnProfile() {
		sleep(2000);
		click(Profile);

	}

	public void clickOnSignIn() {
		click(SignIn);
		sleep(2000);
	}

	public void clickOnLogout() {
		sleep(2000);
		click(Logout);
	}

	public void clickOnLogoutBTN() {
		sleep(2000);
		click(LogoutBTN);
		sleep(1000);
		driver.navigate().refresh();
		
	}

	public void setDestinationName(String nameOfTheDestination) {
		filltext(searchDestinationsField, nameOfTheDestination);
	}

	public void setLoginEmail(String email) {
		filltext(Email, email);
		sleep(1000);
	}

	public void setLoginPassword(String password) {
		sleep(2000);
		filltext(Password, password);

	}

	public void clickOnSearchTextField() {
		click(searchDestinationsField);
		sleep(1000);
	}

	public void clickOnLoginBtn() {
		click(LoginBtn);
		sleep(1000);
	}

	public void clickOnDestinations() {
		sleep(1000);
		click(Destinations);
	}

	/**
	 * Return the status of the "Search" field (empty or not)
	 * 
	 * @return
	 */
	public boolean checkifTheSearchFieldIsEmpty() {
		boolean flag = false;
		sleep(1000);
		if (searchDestinationsField.getAttribute("value").isEmpty()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Return the status of the destination(found or not)
	 * 
	 * @return
	 */
	public boolean destinationsNotFound() {
		boolean flag = false;
		sleep(1000);
		if (distinationsNotFound.getText().equalsIgnoreCase("no Destinations found")) {
			flag = true;
		}
		return flag;
	}

	public boolean destinationsNotFound2() {
		boolean flag = false;
		sleep(1000);
		if (SorryWeCanNotFoundStr.getText().contains("Sorry, we can not find")) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Return the status of the Logo icon which appears on the main page
	 * 
	 * @return
	 */
	public boolean isLogoMainPageEnable() {
		return isElementEnable(logoShichor);

	}

	public boolean isSignInEnable() {
		return isElementEnable(SignIn);

	}

	/**
	 * Return the status of the DestinationsSearchComboBox
	 * 
	 * @return
	 */
	public boolean isDestinationsComboBoxEnable() {
		return isElementEnable(destinationsComboBox);

	}

	public boolean isProfileEnabled() {
		return isElementEnable(MainProfile);
	}

	public boolean isLogoutBtnIsEnabled() {
		return isElementEnable(LogoutBTN);
	}

	/**
	 * Return the status of the DestinationsSearchComboBox
	 * 
	 * @return
	 */
	public boolean isSignInWindowEnable() {
		return isElementEnable(SignIn);

	}

	/**
	 * Return the status of the SearchDestionBtn
	 * 
	 * @return
	 */
	public boolean isSearchDestionBtnEnable() {
		return isElementEnable(searchDestinationBtn);
	}

	/**
	 * Return the status of the Generic Element (enable or disable)
	 * 
	 * @return
	 */
	public boolean isElementEnable(WebElement we) {
		boolean flag = false;
		sleep(1000);
		if (we != null && we.isEnabled()) {
			flag = true;
		}
		return flag;
	}

	public boolean isCountryFoundSearch(String countryname) {
		boolean flag = false;
		if (countryname != null && countryDestinationFound.getText().equalsIgnoreCase(countryname)) {
			flag = true;
		}
		return flag;
	}

}
