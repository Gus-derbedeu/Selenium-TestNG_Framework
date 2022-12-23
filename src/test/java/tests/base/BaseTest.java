package tests.base;

import common.CommonAction;
import org.openqa.selenium.Alert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.base.BasePage;
import pages.habrhome.HabrHomePage;

import java.util.Set;


public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HabrHomePage habrHomePage = new HabrHomePage(driver);

    protected void switchWindow(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String window1 = driver.getWindowHandle();

        js.executeScript("window.open()");

        Set<String> currentWindows = driver.getWindowHandles(); //получаем хеш-коды всех окон (браузера) что у нас есть

        String window2 = null;

        for(String window : currentWindows){
            if(!window.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);

    }

}
