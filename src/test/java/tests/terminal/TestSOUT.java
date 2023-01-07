package tests.terminal;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.filter.DataProviderClass;

public class TestSOUT {

    @Test (dataProvider = "dataProviderMethod", dataProviderClass = DataProviderClass.class)
    public void testSOUT(String number, String string){

        System.out.println("Test terminal: " + number + string);
    }
}
