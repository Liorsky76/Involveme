package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvalidLoginPage extends BasePage {
	@FindBy(css = "[name=email]")
	private WebElement email;
	@FindBy(css = "[name=password]")
	private WebElement password;
	@FindBy(css = ".btn.btn-primary.btn-lg")
	private WebElement LoginSubmit;
	@FindBy(css = ".alert.alert-danger")
	private WebElement credentialsDoNotMatch;

	public InvalidLoginPage(WebDriver driver) {
		super(driver);
	}
	public void login(String Email, String Password) {
		sleep(2000);
		filltext(email, Email);
		filltext(password, Password);
	}
	
	public void clickOnLoginSubmit() {
		sleep(2000);
		click(LoginSubmit);
	}

	public String returnErrorLoginMessage() {

		return credentialsDoNotMatch.getText();

	}

	public boolean retutnMenuMainIfVissible() {
		sleep(3000);
		boolean flagIsVissible = true;
		List<WebElement> menubar = driver.findElements(By.cssSelector(".outer-container.clearfix"));
		for (WebElement menubarLinkBtn : menubar) {
			if (!(menubarLinkBtn.isEnabled()))

			{
				flagIsVissible = false;
				break;
			}

		}
		return flagIsVissible;
	}

	public boolean retutnLoginBtnIfVissible() {
		boolean flagLoginBtn = false;
		if (LoginSubmit.isEnabled()) {
			flagLoginBtn = true;
		}

		return flagLoginBtn;

	}
}