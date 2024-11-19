package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticlePage {
	
	
	
	@FindBy(xpath="//a[text()='New Article']")
	WebElement newArticleLink;
	@FindBy(xpath="//input[@name='title']")
	WebElement title;

	@FindBy(xpath="//input[@name='description']")
	WebElement description;
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement tags;
	
	@FindBy(xpath="//button[text()='Publish Article']")
	WebElement publishBtn;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement articlePage;
	
	@FindBy(xpath="//img[@alt='Umamaheswari']")
	WebElement homePage;
	
	@FindBy(xpath="//div[@class='article-page']")
	WebElement articleTitle;
	
	@FindBy(xpath="//button[text()='Global Feed']")
	WebElement globalFeedBtn;
	
	@FindBy(xpath="//div[@class='article-preview']")
	WebElement globalFeedPage;
	
	@FindBy(xpath="//a[contains(@href,'selenium-types')]")
	WebElement articleLink;
	
	@FindBy(xpath="//div[@class='article-page']//h1[text()='Selenium types']")
	WebElement articleTitleValue;
	
			
	
	

	
	public ArticlePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public boolean createArticle(String titleVal,String descVal, String content, String tagValue) {
	
		title.sendKeys(titleVal);
		description.sendKeys(descVal);
		body.sendKeys(content);
		tags.sendKeys(tagValue);
		publishBtn.submit();
		return true;
		
		
		
	}

	public boolean inHomePage() {

		return homePage.isDisplayed();
		// TODO Auto-generated method stub
		
	}

	public boolean inCreatePage() {

		newArticleLink.click();
		return articlePage.isDisplayed();
	}

	public boolean isArticleCreated() {
		return articleTitle.isDisplayed();
		
	}

	public boolean isGlobalFeedPageDisplayed() {
		globalFeedBtn.click();
		return globalFeedPage.isDisplayed();
	}

	public void selectedArticlePage(String value,WebDriver driver) {
		
		WebElement articleLink=driver.findElement(By.xpath("//h1[text()='"+value+"']//parent::a"));
		articleLink.click();
		
	}


	public boolean articlePageDisplayed() {
		return articleTitleValue.isDisplayed();
	}

}
