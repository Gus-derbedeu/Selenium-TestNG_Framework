package pages.habrhome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class HabrHomePage extends BasePage {


    public HabrHomePage(WebDriver driver) {
        super(driver);
    }
    By navFilters = By.xpath("//button[@class ='tm-navigation-filters-spoiler__button']");
    By bestFilter = By.xpath("//div[@class = 'tm-navigation-filters__options']//button[contains(text(),'Лучшие')]");
    By alltimeFilter = By.xpath("//div[@class = 'tm-navigation-filters__options']//button[contains(text(), 'Всё время')]");
    By applyButton = By.xpath("//button[@class ='tm-navigation-filters__apply btn btn_solid btn_small']");

    public HabrHomePage changeFilter(){
        driver.findElement(navFilters).click();
        driver.findElement(bestFilter).click();
        driver.findElement(alltimeFilter).click();

        return this;
    }

    public HabrHomePage clickToApplyFilter(){
        driver.findElement(applyButton).click();

        return this;
    }
}
