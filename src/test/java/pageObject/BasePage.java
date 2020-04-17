package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);// ask Nir
		
	}

	public void click(WebElement webel) {
		sleep(2000);
		webel.click();
	}

	public void clear(WebElement webel) {
		webel.clear();
	}

	public void filltext(WebElement webel, String text) {
		sleep(2000);
		webel.sendKeys(text);
	}

	public void dragAndDrop(WebElement from, WebElement to) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).build();
		dragAndDrop.perform();
	}

	public String getText(WebElement el) {
		return el.getText();
	}

	public void sleep(long mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}