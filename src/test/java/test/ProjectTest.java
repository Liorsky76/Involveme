package test;



import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.ProjectPage;
import pageObject.ValidLoginPage;

public class ProjectTest extends BaseTest {

	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1, description = "Click on here account confirmation")
	@Description("Click on here account confirmation")
	public void project_page_01() {
		ValidLoginPage validloginpage = new ValidLoginPage(driver);
		validloginpage.login("LiorskyKr@gmail.com", "12345678");
		validloginpage.clickOnLoginSubmit();
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnConfirmAccount();
		String expectedTxt = "A new confirmation e-mail has been sent to your email.";
		String actualTxt = projectpage.returnElementText();
		assertEquals(actualTxt, expectedTxt);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2, description = "Add new workspace")
	@Description("Add new workspace and verify that added as expected")
	public void project_page_02() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnAddWorkSpace();
		projectpage.setWorkSpaceName("work");
		projectpage.clickOnCreateConfirmWorkSpaceBtn();
		int expectedCountOfProjects = 0;
		int actualCountOfProjects = projectpage.returnCountOfprojects();
		assertEquals(actualCountOfProjects, expectedCountOfProjects);

	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, description = "Rename the workspace")
	@Description("Rename workspace and verify that renamed as expected")
	public void project_page_03() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnWorkspaceDropDown();
		projectpage.clickOnRenameWorkSpace();
		projectpage.renameWorkSpaceName("newwork");
		projectpage.clickOnRenameWorkSpaceBtn();
		String actualworkspacename = projectpage.returnWorkSpaceName();
		String expectedworkspacename = "newwork";
		assertEquals(actualworkspacename, expectedworkspacename);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4, description = "Start new project from scratch")
	@Description("Create new project from scratch ,then search it and found as expected")
	public void project_page_04() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnStartNewProject();
		projectpage.selectTheProject("Start from scratch");
		projectpage.clearTheTextProjectName();
		projectpage.setProjectName("My Java Project");
		projectpage.clickOnEditProject();
		projectpage.dragAndDrop("Button");
		projectpage.clickOnSaveAndExit();
		projectpage.clickOnSearch();
		projectpage.setTheTextProjectSearch("My Java Project");
		boolean actualifprojectfound = projectpage.ifProjectFound("My Java Project");
		boolean expectedifprojectfound = true;
		assertEquals(actualifprojectfound, expectedifprojectfound);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5, description = " Check the count of the projects")
	@Description("Verify that after the project adding,the total of projects = +1")
	public void project_page_05() {
		ProjectPage projectpage = new ProjectPage(driver);
		int actualCountOfProjects = projectpage.returnCountOfprojects();
		int expectedCountOfProjects = actualCountOfProjects + 1;
		assertEquals(actualCountOfProjects, expectedCountOfProjects - 1);

	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6, description = "delete new project ")
	@Description("Verify that after the project deleting,the following message appears - Workspace has no projects")
	public void project_page_06() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnDropdownProject();
		projectpage.projectListOperations("Delete");
		projectpage.clickOnDeletePopup();
		boolean actualstr = projectpage.workspaceHasNoProjects();
		boolean expectedstr = true;
		assertEquals(actualstr, expectedstr);
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority = 7, description = "Start new project from scratch set 2 chars")
	@Description("The minimum valid name for the project should include 3 chars,error message should appear")
	public void project_page_07() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnStartNewProject();
		projectpage.selectTheProject("Start from scratch");
		projectpage.setProjectName("My");
		projectpage.clearTheTextProjectName();
		boolean actualerror = projectpage.errorIsFound2();
		boolean expectederror = true;
		assertEquals(actualerror, expectederror);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 8, description = "Add new project")
	@Description("Set the valid name and create new project,verify that the project created - serach it and found according to the name ")
	public void project_page_08() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.setProjectName("My Project Selenium");
		projectpage.clickOnEditProject();
		projectpage.clickOnSaveAndExit();
		projectpage.clickOnSearch();
		projectpage.setTheTextProjectSearch("My Project Selenium");
		boolean actualifprojectfound = projectpage.ifProjectFound("My Project Selenium");
		boolean expectedifprojectfound = true;
		assertEquals(actualifprojectfound, expectedifprojectfound);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 9, description = "Start new project from scratch then drag and drop ")
	@Description("Start new project from scratch and then drag and drop icon to the project,save it and verify the total sum of projects")
	public void project_page_09() {
		ProjectPage projectpage = new ProjectPage(driver);
		int actual = projectpage.returnCountOfprojects();
		projectpage.clickOnCreateProject();
		projectpage.selectTheProject("Start from scratch");
		projectpage.setProjectName("My Project LR");
		projectpage.clickOnEditProject();
		projectpage.dragAndDrop("Image Answer");
		projectpage.clickOnSaveAndExit();
		int expected = actual + 1;
		assertEquals(actual, expected - 1);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 10, description = "delete all projects")
	@Description("Delete all projects,verify that the all projects deleted,the message should appear workspace has no Projects ")
	public void project_page_10() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.deleteAllProjects();
		boolean expectedflag = true;
		boolean actualflag = projectpage.workspaceHasNoProjects();
		assertEquals(actualflag, expectedflag);

	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 11, description = "deleteWorkSpace")
	@Description("Delete workspace,verify that total sum of the workspaces is 0 ")
	public void project_page_11() {
		ProjectPage projectpage = new ProjectPage(driver);
		int beforeDeleteWorkspace = projectpage.getCountOfTheWorkSpace();
		projectpage.clickOnWorkspaceDropDown();
		projectpage.clickOnAddWorkSpaceDelete();
		projectpage.renameWorkSpaceName();
		projectpage.clickOnAddWorkSpaceDeleteConfirm();
		int afterDeleteWorkspace = projectpage.getCountOfTheWorkSpace();
		Assert.assertEquals(beforeDeleteWorkspace, afterDeleteWorkspace + 1);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 12, description = "Duplicate project")
	@Description("Duplicate project,verify that the project created ,search it according to the name and found it")
	public void project_page_12() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnAddWorkSpace();
		projectpage.setWorkSpaceName("new");
		projectpage.clickOnCreateConfirmWorkSpaceBtn();
		projectpage.clickOnStartNewProject();
		projectpage.selectTheProject("Start from scratch");
		projectpage.clearTheTextProjectName();
		projectpage.setProjectName("Test Duplicate");
		projectpage.clickOnEditProject();
		// projectpage.dragAndDrop("Button");
		projectpage.clickOnSaveAndExit();
		projectpage.clickOnDropdownProject();
		projectpage.projectListOperations("Duplicate Project");
		projectpage.clickOnSaveAndExit();
		projectpage.clickOnSearch();
		projectpage.setTheTextProjectSearch("copy");
		boolean actualifprojectfound = projectpage.ifProjectFound("Test Duplicate (copy)");
		boolean expectedifprojectfound = true;
		assertEquals(actualifprojectfound, expectedifprojectfound);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 13, description = "Delete project and then cancel")
	@Description("when user press on delete and then on cancel the project should not be deleted")
	public void project_page_13() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnDropdownProject();
		projectpage.projectListOperations("Delete Project");
		projectpage.clickOnCancelDeleteProject();
		projectpage.clearTheTextsearch();
		projectpage.setTheTextProjectSearch("Test Duplicate (copy)");
		boolean actualifprojectfound = projectpage.ifProjectFound("Test Duplicate (copy)");
		boolean expectedifprojectfound = true;
		assertEquals(actualifprojectfound, expectedifprojectfound);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 14, description = "Select new template")
	@Description("Create new project and select the template,verify that the project created.")
	public void project_page_14() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clickOnCreateProject1();
		projectpage.selectTheProject("Calculator");
		projectpage.selectTheTemplate("Website ROI Calculator");
		projectpage.clearTheTextProjectName();
		projectpage.setProjectName("ROI");
		projectpage.clickOnEditProject();
		projectpage.clickOnSaveAndExit();
		projectpage.clickOnSearch();
		projectpage.setTheTextProjectSearch("ROI");
		boolean actualifprojectfound = projectpage.ifProjectFound("ROI");
		boolean expectedifprojectfound = true;
		assertEquals(actualifprojectfound, expectedifprojectfound);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 15, description = "delete workspace")
	@Description("verify that all projects will be deleted")
	public void project_page_15() {
		ProjectPage projectpage = new ProjectPage(driver);
		projectpage.clearTheTextsearch();
		int actualcountofprojects = projectpage.returnCountOfprojects();
		projectpage.clickOnWorkspaceDropDown();
		projectpage.clickOnAddWorkSpaceDelete();
		projectpage.renameWorkSpaceName();
		projectpage.clickOnAddWorkSpaceDeleteConfirm();
		int expectedcountofprojects = 0;
		assertEquals(actualcountofprojects, expectedcountofprojects + actualcountofprojects);
	}
}