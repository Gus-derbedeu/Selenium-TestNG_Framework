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
    By applyButton = By.xpath("//button[@class ='tm-navigation-filters__apply btn btn_solid btn_small']");

    protected WebElement FilterOptions (String option){
        return driver.findElement(By.xpath("//div[@class = 'tm-navigation-filters__options']//button[contains(text(),'" + option + "')]"));
    }




    public HabrHomePage changeFilter(String show, String period ){
        driver.findElement(navFilters).click();
        if (show == "new"){
            FilterOptions("Новые").click();
            switch (period){
                case "all": FilterOptions("Все").click();
                    break;
                case "zero": FilterOptions("≥0").click();
                    break;
                case "ten": FilterOptions("≥10").click();
                    break;
                case "twentyfive": FilterOptions("≥25").click();
                    break;
                case "fifty": FilterOptions("≥50").click();
                    break;
                case "hundred": FilterOptions("≥100").click();
                    break;

            }

        }
        else if (show == "best"){
            FilterOptions("Лучшие").click();
            switch (period){
                case "day": FilterOptions("Сутки").click();
                    break;
                case "week": FilterOptions("Неделя").click();
                    break;
                case "month": FilterOptions("Месяц").click();
                    break;
                case "year": FilterOptions("Год").click();
                    break;
                case "alltime": FilterOptions("Всё время").click();
                    break;

            }
        }
        else {

            System.out.println("Ошибка: неправильные параметры фильтра - применен стандарт - 'новые' и 'все' ");
            FilterOptions("Новые").click();

        }
        driver.findElement(applyButton).click();
        return this;
    }

    public HabrHomePage checkCountArticles(){
        waitElementIsVisible(driver.findElement(article));
        List<WebElement> articleList = driver.findElements(article);
        System.out.println("Количество статей : " + articleList.size());
        Assert.assertEquals(articleList.size(), 20);
        return this;
    }



    public HabrHomePage openArticle (int articleNumber, String tab) {
        waitElementIsVisible(driver.findElement(article));
        List<WebElement> articleList = driver.findElements(article);
        WebElement link = articleList.get(articleNumber-1).findElement(By.className("tm-article-snippet__title-link"));
        if (tab == "old") {
            link.click();
        }
        else if (tab == "new"){
            String keyString =  Keys.CONTROL+Keys.SHIFT.toString()+ Keys.ENTER;
            link.sendKeys(keyString);
        }
        else {
            System.out.println("Ошибка: Только old или new в параметре артикла - ссылка открыта в том же окне ");
            link.click();
        }
        return this;
    }

}
