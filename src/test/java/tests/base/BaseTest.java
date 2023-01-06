package tests.base;

import common.CommonAction;
import org.openqa.selenium.Alert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.AfterSuite;
import pages.base.BasePage;
import pages.habrhome.HabrHomePage;

import java.util.Set;


public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HabrHomePage habrHomePage = new HabrHomePage(driver);

@AfterSuite(alwaysRun = true)
public void closeBrowser (){
    driver.quit();
}

}
