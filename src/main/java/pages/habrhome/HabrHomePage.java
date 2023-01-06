package pages.habrhome;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.List;




public class HabrHomePage extends BasePage {


    public HabrHomePage(WebDriver driver) {
        super(driver);
    }
    private final By article = By.className("tm-articles-list__item");



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



    public HabrHomePage checkCountArticles(){
        waitElementIsVisible(driver.findElement(article));
        List<WebElement> articleList = driver.findElements(article);
        {System.out.println("Количество статей : " + articleList.size());}
        Assert.assertEquals(articleList.size(), 20);
        return this;
    }

    public HabrHomePage openArticle (int articleNumber){
        waitElementIsVisible(driver.findElement(article));
        List<WebElement> articleList = driver.findElements(article);
        WebElement link = articleList.get(articleNumber-1).findElement(By.className("tm-article-snippet__title-link"));
        link.click();

        return this;
    }
    public HabrHomePage openArticleNewTab (int articleNumber){
        waitElementIsVisible(driver.findElement(article));
        List<WebElement> articleList = driver.findElements(article);
        WebElement link = articleList.get(articleNumber-1).findElement(By.className("tm-article-snippet__title-link"));
        String keyString =  Keys.CONTROL+Keys.SHIFT.toString()+ Keys.ENTER;
        link.sendKeys(keyString);
        return this;
    }
}
