package tests.filter;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.IOException;


public class FilterTest extends BaseTest {
         @Test (timeOut = 5000, successPercentage = 100) //(invocationCount = 2)  - количество раз сколько нужно выполнить тест
         // (successPercentage = 100) - процент успеха теста чтобы он не упал
         public void checkIsFilterApplying(){

         basePage.open("https://habr.com");
         Assert.assertTrue(driver.getPageSource().contains("Хабр"),"Страница не прогрузилась!" );


         habrHomePage
                .changeFilter("best", "year") // show: new/best, period: all,zero,ten,twentyfive, fifty, hundred /  day,week,month,year,alltime
                .checkCountArticles()
                .openArticle(19, "new");  //"old" или "new" открыть в новой вкладке или в той же - если написать что-то другое, то выполнит в "old"



         }
}
