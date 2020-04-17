package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {
	@FindBy(css = ".underline")
	private WebElement clickHereToConfirmAccount;
	@FindBy(css = ".alert.alert-success.mt-2.bg-teal-100.border-t-4.border-teal-500.rounded.text-teal-900.px-4.py-3.shadow-md")
	private WebElement email_has_been_sent;
	@FindBy(css = "[href=\"https://app.involve.me/logout\"]")
	private WebElement logout;
	@FindBy(css = ".fas.fa-caret-down.ml-2")
	private WebElement dropdownLogin;
	@FindBy(css = ".flex.flex-col.justify-center.items-center>a")
	private WebElement startnewproject;
	@FindBy(css = ".form-group>#project-name")
	private WebElement setprojectname;
	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement starteditproject;
	@FindBy(css = ".e-close.nav-link")
	private WebElement saveandexit;
	@FindBy(css = ".block.text-3xl.font-medium.text-gray-900.leading-none.mb-8")
	private WebElement projectnotfound;
	@FindBy(css = "[data-icon=search]")
	private WebElement search;
	@FindBy(css = ".flex.items-center.justify-between.mb-2 .dropdown.relative>[data-toggle=\"dropdown\"]")
	private WebElement dropdownproject;
	@FindBy(css = "#confirm-delete-button")
	private WebElement confirmdeletebuton;
	@FindBy(css = ".block.max-w-xl.text-2xl.font-medium.text-gray-800.leading-tight.mb-4.text-center")
	private WebElement workspacehasnoproject;
	@FindBy(css = ".content-item-wrapper.shadow.empty_canvas")
	private WebElement newproject_draganddrop;
	@FindBy(css = ".btn.btn-secondary.save-btn")
	private WebElement publishbutton;
	@FindBy(css = "#confirm-publish-button")
	private WebElement confirmpublishbutton;
	@FindBy(css = ".px-4.md\\:flex > a")
	private WebElement createproject;
	@FindBy(css = ".form-group>#project-name-error")
	private WebElement thisfieldisrequired;
	@FindBy(css = "#new-project-form>.form-group>#project-name-error")
	private WebElement errorAtleast3char;
	@FindBy(css = ".form-group #multiple-outcomes")
	private WebElement checkbox;
	@FindBy(css = ".flex.justify-between.text-lg.font-medium.px-5 > button")
	private WebElement createNewWorkSpace;
	@FindBy(css = ".inline-block.no-underline.font-normal.h-10.px-6.leading-loose.rounded.shadow.bg-teal-500.text-white")
	private WebElement confirmCreateWspaceBut;
	@FindBy(css = ".content-item-wrapper.shadow.empty_canvas")
	private WebElement toDropZone;
	@FindBy(css = ".rounded.h-8.bg-transparent")
	private WebElement searchField;
	@FindBy(css = " a > span:nth-child(2)")
	private WebElement projectcounts;
	@FindBy(css = ".block .items-center > div > div > button > svg")
	private WebElement workspacedropdown;
	@FindBy(css = "li:nth-child(2) > button")
	private WebElement deleteworkspace;
	// this should be a list
	@FindBy(css = "span.mr-3.truncate")
	private WebElement workspace;
	@FindBy(css = ".h-12")
	private WebElement setworkspacename;
	@FindBy(css = "#confirm-create-button")
	private WebElement deleteconfirmworkspacename;
	@FindBy(css = ".pl-4.pr-4.w-full.block.leading-loose.text-left.text-sm")
	private WebElement renameworkspace;
	@FindBy(css = ".ml-auto>#confirm-create-button")
	private WebElement renameconfirmworkspacename;
	@FindBy(css = ".text-gray-900.text-xl")
	private WebElement workspacename;
	@FindBy(css = ".inline-block.no-underline.text-gray-600")
	private WebElement cancelDeleteProjectBtn;
	@FindBy(css = "#filter-calculator")
	private WebElement countCalculatorTemplate;
	@FindBy(css = "#filter-all")
	private WebElement countAllTemplate;
	@FindBy(css = ".btn.btn-primary")
	private WebElement chooseTheTemplateBtn;
	@FindBy(css = ".md\\:px-0.items-center > a")
	private WebElement createProjectBtn;
	@FindBy(css = ".items-start.md\\:flex-grow > a:nth-child(2)")
	private WebElement templateMenu;
	
	public ProjectPage(WebDriver driver) {
		super(driver);

	}

	public void setProjectName(String projectname) {
		wait.until(ExpectedConditions.visibilityOfAllElements(setprojectname));
		filltext(setprojectname, projectname);
	}

	public void setWorkSpaceName(String workspacenamename) {
		sleep(1000);
		filltext(setworkspacename, workspacenamename);
	}

	public void renameWorkSpaceName() {
		sleep(3000);
		filltext(setworkspacename, returnNameOfWorkSpace());
	}

	public void renameWorkSpaceName(String newworkspacename) {
		clear(setworkspacename);
		filltext(setworkspacename, newworkspacename);
	}

	public void clickOnConfirmAccount() {
		sleep(2000);
		click(clickHereToConfirmAccount);
	}
	
	public void clickOnTemplateFromTheMenu() {
		sleep(2000);
		click(templateMenu);
	}
	
	public void clickOnCreateProject1() {
		sleep(2000);
		click(createProjectBtn);
	}

	public void clickOnWorkspaceDropDown() {
		sleep(2000);
		click(workspacedropdown);
	}

	public void clickOnCancelDeleteProject() {
		sleep(2000);
		click(cancelDeleteProjectBtn);

	}

	public void clickOnAddWorkSpace() {
		click(createNewWorkSpace);

	}

	public void clickOnRenameWorkSpaceBtn() {
		click(renameconfirmworkspacename);

	}

	public void clickOnRenameWorkSpace() {
		click(renameworkspace);

	}

	public void clickOnAddWorkSpaceDelete() {
		click(deleteworkspace);

	}

	public void clickOnAddWorkSpaceDeleteConfirm() {
		click(deleteconfirmworkspacename);

	}

	public void clickOnCreateConfirmWorkSpaceBtn() {
		click(confirmCreateWspaceBut);

	}

	public void clickOnCreateProject() {
		sleep(1000);
		click(createproject);
	}

	public void clickOnCheckbox() {
		click(checkbox);
	}

	public String returnElementText() {
		String text = email_has_been_sent.getText();
		return text;
	}

	public String returnWorkSpaceName() {
		sleep(2000);
		return workspacename.getText();
	}

	public void clickOnDropdownLogin() {
		click(dropdownLogin);
	}

	public void clickOnPublishConfirm() {
		click(confirmpublishbutton);
	}

	public void clickOnDropdownProject() {
		sleep(3000);
		click(dropdownproject);
	}

	public void clickOnSearch() {
		click(search);
		 Actions builder = new Actions(driver);
		 builder.moveToElement(searchField).build().perform();
		
	}

	public void clickOnSaveAndExit() {
		click(saveandexit);
		sleep(3000);
	}

	public void clickOnEditProject() {
		sleep(2000);
		click(starteditproject);
	}

	public void clickOnLogout() {
		click(logout);
	}

	public void clickOnPublishBtn() {
		click(publishbutton);
	}

	public void clickOnDeletePopup() {
		sleep(1000);
		click(confirmdeletebuton);
	}

	public void clickOnStartNewProject() {
		click(startnewproject);
		sleep(2000);
	}

	public void clearTheTextProjectName() {
		sleep(5000);
		clear(setprojectname);
	}

	public void clearTheTextWorkSpace() {
		sleep(2000);
		clear(workspace);
	}

	public void clearTheTextsearch() {
		clear(searchField);
	}

	public void setTheTextProjectSearch(String projectname) {
		filltext(searchField, projectname);
	}
	
	public int returnCountOfprojects() {
		sleep(2000);
		String projectcount = projectcounts.getText();
		int projectCount = Integer.parseInt(projectcount);
		return projectCount;
	}
	
	public int returnCountOfTemplateCalculator() {
		sleep(2000);
		String countoftemplatecalculator = countCalculatorTemplate.getText();
		String number= countoftemplatecalculator.split("\n")[1];
		int templateCalculatorCount = Integer.parseInt(number);
		return templateCalculatorCount;
	}
	public int returnCountOfAllTemplates() {
		sleep(2000);
		String countofalltemplates = countAllTemplate.getText();
		String number= countofalltemplates.split("\n")[1];
		int allCount = Integer.parseInt(number);
		return allCount;
	}
	public String returnNameOfWorkSpace() {
		String workspacename = workspace.getText();
		return workspacename;
	}

//check if the project was found
	public boolean ifProjectFound(String projectname) {
		boolean ifprojectfound = false;
		sleep(3000);
		List<WebElement> projects = driver.findElements(By.cssSelector(".leading-tight.text-lg.font-medium"));
		for (int i = 0; i < projects.size(); i++) {
			if (projectname.equalsIgnoreCase(projects.get(i).getText())) {
				ifprojectfound = true;
			}
		}

		return ifprojectfound;
	}

//create from scratch and create project
	public void selectTheProject(String projectname) {
		sleep(5000);
		List<WebElement> projectlist = driver.findElements(By.cssSelector(".title"));
		for (int i = 0; i < projectlist.size(); i++) {
			if (projectname == "Start from scratch") {
				projectlist.get(0).click();
				break;
			}
			if (projectname.contains(projectlist.get(i).getText())) {
				click(projectlist.get(i));
				break;
			}
		}
	}

	
	
	//select template to the project
		public void selectTheTemplate(String templatename) {
			sleep(3000);
			List<WebElement> templatelist = driver.findElements(By.cssSelector(".details-container"));
			sleep(3000);
			List<WebElement> choosebtnlist = driver.findElements(By.cssSelector(".btn.btn-primary"));
			for (int i = 0; i < templatelist.size(); i++) {
				if ( templatelist.get(i).getText().equalsIgnoreCase(templatename)) {
					Actions action = new Actions(driver);
					action.moveToElement(templatelist.get(i)).build().perform();
					wait.until(ExpectedConditions.visibilityOfAllElements(choosebtnlist.get(i)));
					click(choosebtnlist.get(i));
					break;
				}
			}
		}
	public void clickOnPublish2() {
		sleep(2000);
		List<WebElement> list = driver.findElements(By.cssSelector(".relative.py-2"));
		click(list.get(4));
	}

	public String workSpaceName() {
		return workspace.getText();
	}

	public boolean workspaceHasNoProjects() {
		sleep(3000);
		boolean noPproject = false;
		String expectedstr = "This workspace has no projects";
		if (workspacehasnoproject.isDisplayed()) {
			String actualstr = workspacehasnoproject.getText();
			noPproject = actualstr.contains(expectedstr);
		}
		return noPproject;
	}

	// Integer.parseInt(getText(numOfPublished)

	public void dragAndDrop(String Item) {
		sleep(3000);
		List<WebElement> iconsNames = driver.findElements(By.cssSelector("div.svg-wrapper+p"));		
		for (WebElement cubeIcon : iconsNames) {
			if (cubeIcon.getText().equalsIgnoreCase(Item)) {
				WebElement toDropZone = driver.findElement(By.cssSelector(".content-item-wrapper.shadow.empty_canvas"));
				// Using Action class for drag and drop.
				Actions act = new Actions(driver);
				// Dragged and dropped.
				sleep(2000);
				act.dragAndDrop(cubeIcon, toDropZone).build().perform();
				break;
			}
		}
	}

	public void deleteAllProjects() {
		sleep(2000);
		List<WebElement> projects = driver
				.findElements(By.cssSelector(".relative.flex.flex-col.pt-2.px-3.pb-2.rounded"));

		for (int i = 0; i < projects.size(); i++) {
			clickOnDropdownProject();
			sleep(2000);
			projectListOperations("Delete Project");
			clickOnDeletePopup();
			sleep(1000);
		}
	}

	public int getNumberOfProjects() {
		sleep(2000);
		List<WebElement> projects = driver.findElements(By.cssSelector(".relative.flex.flex-col.pt-2.px-3.pb-2.rounded"));
		return projects.size();
	}

	public int getCountOfTheWorkSpace() {
		sleep(2000);
		List<WebElement> workspace = driver.findElements(By.cssSelector(".px-5"));
		return workspace.size();

	}

	public boolean errorIsFound() {
		boolean errorflag = false;
		if (thisfieldisrequired.isDisplayed()) {
			String errorstr = thisfieldisrequired.getText();
			String expectederrorstr = "This field is required.";
			if (expectederrorstr.equalsIgnoreCase(errorstr)) {
				errorflag = true;
			}

		}
		return errorflag;

	}

	public boolean errorIsFound2() {
		boolean errorflag = false;
		if (errorAtleast3char.isDisplayed()) {
			String errorstr = errorAtleast3char.getText();
			String expectederrorstr = "Please enter at least 3 characters.";
			if (expectederrorstr.equalsIgnoreCase(errorstr)) {
				errorflag = true;
			}

		}
		return errorflag;

	}

	// get string and perform the operation from the ProjectListOperations
	public void projectListOperations(String item) {
		sleep(4000);
		List<WebElement> projectoperationslist = driver.findElements(By.cssSelector(".pl-4.pr-4 "));
		for (WebElement operation : projectoperationslist) {
			if (operation.getText().contains(item)) {
				click(operation);
				break;
			}
		}
	}

}
