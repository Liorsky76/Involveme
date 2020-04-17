package pageObject;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValidLoginPage extends BasePage {
	@FindBy(css = "[name=email]")
	private WebElement email;
	@FindBy(css = "[name=password]")
	private WebElement password;
	@FindBy(css = ".btn.btn-primary.btn-lg")
	private WebElement LoginSubmit;
	@FindBy(css = ".alert.alert-danger")
	private WebElement credentialsDoNotMatch;

	public ValidLoginPage(WebDriver driver) {
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

	
	public boolean retutnLoginBtnIfVissible() {
		boolean flagLoginBtn = false;
		if (LoginSubmit.isEnabled()) {
			flagLoginBtn = true;
		}

		return flagLoginBtn;

	}
}