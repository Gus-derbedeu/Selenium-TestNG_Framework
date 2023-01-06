package tests.filter;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class FilterTest extends BaseTest {
         @Test (timeOut = 5000) //(invocationCount = 2)  - количество раз сколько нужно выполнить тест
         public void checkIsFilterApplying(){

         basePage.open("https://habr.com");

         habrHomePage
                .changeFilter("best", "year") // show: new/best, period: all,zero,ten,twentyfive, fifty, hundred /  day,week,month,year,alltime
                .checkCountArticles()
                .openArticle(2, "new");  //"old" или "new" открыть в новой вкладке или в той же - если написать что-то другое, то выполнит в "old"



         }
}
