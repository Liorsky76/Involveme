package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

	@FindBy(css = ".flex.items-center.flex-shrink-0")
	private WebElement involvemeLink;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public boolean returnIfTheLinkIsEnabled() {
		boolean flag = false;
		if (involvemeLink.isEnabled()) {
			flag = true;
		}
		return flag;
	}

}
