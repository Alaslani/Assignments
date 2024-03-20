package Test.testng;

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
public class Assig4_5 extends Tests {
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getData")
    public void testSearch(String searchTerm) {
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");

        bot.type(By.id("input-email"), "clarusway@gmail.com");
        bot.type(By.id("input-password"), "123456789");
        bot.click(By.xpath("//input[@value='Login']"));

        bot.type(By.xpath("//input[@name='search']"), searchTerm);
        bot.click(By.xpath("//span[@class='input-group-btn']"));
    }
}