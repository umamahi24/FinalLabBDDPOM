package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditArticlePage {

	ArticlePage articlePage;
    WebDriver driver;

	
	@FindBy(xpath="//a[contains(text(),'Edit Article')]")
   WebElement editArticelBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateBtn;
	
	@FindBy(xpath="//a[@class='author']")
	WebElement articelPageView;
	

	@FindBy(xpath="//input[@name='title']")
	WebElement title;
	
	@FindBy(xpath="//button[contains(text(),'Delete')]")
	WebElement deletebtn;
	
	@FindBy(xpath="//div[@class='article-page']//h1[text()='selenium type11']")
	WebElement editArticleValue;
	
	@FindBy(xpath="//div[text()='Articles not available.']")
	WebElement articleDeleted;
	
	
	public EditArticlePage(WebDriver driver1) {
		PageFactory.initElements(driver1, this);
		driver=driver1;
	}
	
	public void editArticleTest() {	
		title.clear();
		title.sendKeys("selenium type11");
		updateBtn.click();
	}

	

	public void clickEditArticle() {
		// TODO Auto-generated method stub
		editArticelBtn.click();
		
	}

	public boolean isEditedDetailsDisplayed() {
		boolean val=editArticleValue.isDisplayed();
		return val;
		
	}

	public void deleteArticle() {
		deletebtn.click();
		driver.switchTo().alert().accept();
		// TODO Auto-generated method stub
		
	}

	public boolean isArticleDeleted() {
		
		return articleDeleted.isDisplayed() ;
	}
}
