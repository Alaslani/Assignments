package Test.testng;

import Test.testng.Tests;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*/
//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.

(create an array structure with "Mac, iPad and Samsung". You can see it in Assignment 2)
 */
public class Assig44_5 extends Tests {


    @Test(dataProvider = "getData")
    public void test (String word){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement
    }

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }

    @Test(priority = 2, dataProvider = "searchData")
    public void searchForProducts(String searchQuery) {
        bot.type(By.name("search"), searchQuery);
        bot.click(By.xpath("//i[@class='fa fa-search']"));
        logger.info("Searched for: " + searchQuery);
        // Add assertions or further actions as needed.
    }
}
