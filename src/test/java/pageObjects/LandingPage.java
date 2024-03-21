package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver= driver;
	}
	

	private By search = By.xpath("//input[@id='twotabsearchtextbox']");
	private By firstProduct = By.xpath("//div[3]//span[1]/div[1]//h2[1]/a[1]/span[1]");
	private By secondProduct = By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[2]");
	private By priceOnProductPage = By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//div[1]");
	private By goToCart = By.xpath("//span[@id='sw-gtc']");
	private By productlaptop = By.xpath("(//span[@id='submit.add-to-cart-announce'])[2]");
	private By addToCart = By.xpath("//input[@id='add-to-cart-button']");
	private By cartButton= By.xpath("//span[@id='attach-sidesheet-view-cart-button']");
	private By priceOnCartPage = By.xpath("(//div[@class='a-section a-spacing-mini']//span)[1]");
	private By subTotalPrice = By.xpath("//span[@id='sc-subtotal-label-activecart']/following::span[1]");
	
	

	
	private By cartlist = By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']");
	
	public List<WebElement> allPrice()
	{
	return driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
	
	}
	public void searchItem(String name)
	{
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys(name);
	}
	public void clickEnter()
	{
		driver.findElement(search).sendKeys(Keys.ENTER);
	}
	
	public void getSearchText(String name)
	{
		driver.findElement(search).getText();
	}	
	
	public void clcikFirstProduct()
	{
		driver.findElement(firstProduct).click();
	}
	
	public void clcikSecondProduct() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(secondProduct).click();
	}
	public void addToCart() throws InterruptedException
	{
		
		driver.findElement(addToCart).click();
		Thread.sleep(6000);
//		WebElement element2=driver.findElement(By.xpath("//span[@id='attachSiNoCoverage']"));
//		if(element2.isDisplayed())
//			{element2.click();
//			
//			}
	}
	
	public void addToCartlaptop() throws Exception
	{
		driver.navigate().refresh();
		WebElement element=driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[37]/div[1]/span[1]/span[1]/span[1]/input[1]"));
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		WebElement element2=driver.findElement(By.xpath("//span[@id='attachSiNoCoverage']"));
		element2.click();
	}
	
	public void cartButton()
	{
		driver.findElement(cartButton).click();
	}
	
	public void goTocartButton() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.findElement(goToCart).click();
		
	}
	public String getSubTotalPrice()
	{
		return driver.findElement(subTotalPrice).getText();
	}
	public String getPriceOnCartPage()
	{
		return driver.findElement(priceOnCartPage).getText();
	}
	
	public String getPriceOnProductPage()
	{
		return driver.findElement(priceOnProductPage).getText();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}

}
