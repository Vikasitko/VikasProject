package stepDefitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefition {
	TestContextSetup textContextSetup;
	public String subtotal_price;
	LandingPage landingPage;
	public String price_on_cardpage;
	public String eachItemPrice_cartPage;

	public LandingPageStepDefition(TestContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
		this.landingPage = textContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on Amazon Landing page")
	public void user_is_on_amazon_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("Online Shopping site in India"));
	}

	@When("User searched with name as {string} and extract actual price of the product")
	public void user_searched_with_name_as_and_extract_actual_price_of_the_product(String name)
			throws InterruptedException {
		landingPage.searchItem(name);
		Thread.sleep(2000);
		landingPage.clickEnter();

	}

	@When("User click on the first item")
	public void user_click_on_the_first_item() throws InterruptedException {
		landingPage.clcikFirstProduct();
		Thread.sleep(10000);
		//System.out.println("First Product is clicked");
	}

	@When("User add the item by clicking on Add to Cart button")
	public void user_add_the_item_by_clicking_on_add_to_cart_button() throws InterruptedException {
		switchToOfferpage();
		textContextSetup.LandingPageproductPrice = landingPage.getPriceOnProductPage().split("₹")[1].trim();
		System.out.println(textContextSetup.LandingPageproductPrice);
		landingPage.addToCart();
		Thread.sleep(2000);
		//System.out.println("Clicked on add to cart page");
	}

	public void switchToOfferpage() {
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		textContextSetup.genericUtils.switchWindowToChild();
	}

	@When("User close child window")
	public void user_close_child_window() throws InterruptedException {
		closeChildWindow();
	}

	public void closeChildWindow() throws InterruptedException {
		LandingPage landingPage = textContextSetup.pageObjectManager.getLandingPage();
		Thread.sleep(2000);
		textContextSetup.genericUtils.closeToChildWindow();
	}

	@When("User add item by clicking on Add to Cart button")
	public void useradd_item_by_clicking_on_add_to_cart_button() throws Exception {
		switchToOfferpage();
		textContextSetup.LandingPageproductPrice = landingPage.getPriceOnProductPage().split("₹")[1].trim();
		System.out.println(textContextSetup.LandingPageproductPrice);
		Thread.sleep(2000);
		landingPage.addToCartlaptop();
		Thread.sleep(2000);
		//System.out.println("Clciked on add to cart page");
	}

	@When("Open the cart")
	public void open_the_cart() throws InterruptedException {
		Thread.sleep(2000);
		landingPage.cartButton();
		//System.out.println(" Cart button is clicked");
	}

	@When("Open the goToCart")
	public void open_the_goToCart() throws InterruptedException {
		Thread.sleep(2000);
		landingPage.goTocartButton();
		//System.out.println(" Cart button is clicked");
	}

	@Then("Verify that the price is identical to the product page")
	public void verify_that_the_price_is_identical_to_the_product_page() {
		price_on_cardpage = landingPage.getPriceOnCartPage();
		Assert.assertTrue(price_on_cardpage.contains(textContextSetup.LandingPageproductPrice));

	}

	@Then("Verify that the sub total is identical to the product page")
	public void verify_that_the_sub_total_is_identical_to_the_product_page() {
		subtotal_price = landingPage.getSubTotalPrice();
		Assert.assertTrue(subtotal_price.contains(textContextSetup.LandingPageproductPrice));
		//System.out.println("SubTotalPrice is " + landingPage.getSubTotalPrice());
	}

	@When("User click on the second item")
	public void user_click_on_the_second_item() throws InterruptedException {
		Thread.sleep(3000);
		landingPage.clcikSecondProduct();
		Thread.sleep(1000);
		//System.out.println("Second Product is clicked");
	}

	@Then("Verify that each  item price is identical to the product page")
	public void verify_that_each_item_price_is_identical_to_the_product_page() {
		System.out.println("Second Product is clicked");
	}

	@Then("Verify that the sub total is identical to sum of item price")
	public void verify_that_the_sub_total_is_identical_to_sum_of_item_price() {
		List<WebElement> allprice = landingPage.allPrice();
		float itemPriceSum = 0;
		for (WebElement price : allprice) {
			String priceItem = price.getText().trim().replaceAll("[,]", "");
			float number = Float.parseFloat(priceItem);
			itemPriceSum = itemPriceSum + number;
			//System.out.println("Sum is now in float " + itemPriceSum);
		}
		subtotal_price = landingPage.getSubTotalPrice().trim().replaceAll("[,]", "");
		float subTotalPrice = Float.parseFloat(subtotal_price);
		//System.out.println("Sub Total is " + subTotalPrice);
		Assert.assertEquals(itemPriceSum, subTotalPrice, 0.0f);
	}

}
