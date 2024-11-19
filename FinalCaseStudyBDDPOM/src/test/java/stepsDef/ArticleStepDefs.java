package stepsDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ArticlePage;
import page.EditArticlePage;
import page.LoginPage;

public class ArticleStepDefs {

	WebDriver driver;
	LoginPage loginPage;
	ArticlePage articlePage;
	EditArticlePage editArticlePage;
	String articleLink;

	public ArticleStepDefs() {
		TestBase.initDriver();// initi driver
		driver = TestBase.getDriver();// get driver
		loginPage = new LoginPage(driver);// passing driver to each page object
		articlePage = new ArticlePage(driver);
		editArticlePage = new EditArticlePage(driver);

	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");

	}

	@When("User provide {string} and {string}")
	public void user_provide_and(String userName, String pswd) {
		loginPage.validLogin(userName, pswd);

	}

	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(articlePage.inHomePage());

	}
	
	@Given("User should be on Article Page")
	public void user_should_be_on_article_page() {
		Assert.assertTrue(articlePage.inCreatePage());

	}

	@When("Use enters Article details")
	public void use_enters_article_details(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		String titleVal = data.get(0).get("title");
		String des = data.get(0).get("Desc");
		String content = data.get(0).get("Content");
		String tagVal = data.get(0).get("tag");
		articlePage.createArticle(titleVal, des, content, tagVal);
	}

	@Then("Article must be created")
	public void article_must_be_created() {
		Assert.assertTrue(articlePage.isArticleCreated());
	}
	

	@Given("User should be on Global Feed page")
	public void user_should_be_on_global_feed_page() {
		Assert.assertTrue(articlePage.isGlobalFeedPageDisplayed());
		

	}
	@When("User select an article {string}")
	public void user_select_an_article(String value) {
		articlePage.selectedArticlePage(value,driver);
		

	}
	
	@Given("Article detail page must be displayed")
	public void article_detail_page_must_be_displayed() {
		Assert.assertTrue(articlePage.articlePageDisplayed());

	}

	@When("User update article detail")
	public void user_update_article_detail() {
		editArticlePage.clickEditArticle();
		editArticlePage.editArticleTest();
	}

	@Then("Article detail page must be updated")
	public void article_detail_page_must_be_updated() {
		Assert.assertTrue(editArticlePage.isEditedDetailsDisplayed());


	}

	@When("User delete article")
	public void user_delete_article() {
		editArticlePage.deleteArticle();
	}

	@Then("Article must be deleted")
	public void article_must_be_deleted() {
		Assert.assertTrue(editArticlePage.isArticleDeleted());
	}


}
