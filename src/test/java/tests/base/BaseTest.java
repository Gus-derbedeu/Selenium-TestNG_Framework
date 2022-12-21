package tests.base;

import common.CommonAction;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.habrhome.HabrHomePage;
import pages.listing.HabrListingPage;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HabrHomePage habrHomePage = new HabrHomePage(driver);
    protected HabrListingPage habrListingPage = new HabrListingPage(driver);
}
