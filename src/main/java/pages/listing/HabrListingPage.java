package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;
import pages.habrhome.HabrHomePage;

public class HabrListingPage extends BasePage {

    public HabrListingPage(WebDriver driver) {
        super(driver);
    }
    private final By article = By.xpath("//div[@class='tm-articles-list']//article");

    public HabrListingPage checkCountArticles(){

        waitElementIsVisible(driver.findElement(article));

        int countArticle = driver.findElements(article).size();
        Assert.assertEquals(countArticle, 20);
        return this;
    }
}
