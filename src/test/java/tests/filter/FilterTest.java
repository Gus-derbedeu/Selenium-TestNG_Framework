package tests.filter;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class FilterTest extends BaseTest {
         @Test
         public void checkIsFilterApplying(){

         basePage.open("https://habr.com");



         habrHomePage
                .changeFilter()
                .clickToApplyFilter()
                .checkCountArticles()
                .openArticleNewTab(3);



         }
}
