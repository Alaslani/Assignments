
package Test.testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*/
 //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ''Invalid credentials'’ is displayed.
    //Run it parallel with 3 threads
    //Generate Allure report


  @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"admin*","admin123"},
                {"admin12","123"},
                {"Admin1","***00**"},
                {"test","123"},
                {"user","369"},
		}
        };
 */
public class Assig2_5 extends Tests {

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"admin*", "admin123"},
                {"admin12", "123"},
                {"Admin1", "***00**"},
                {"test", "123"},
                {"user", "369"},
        };
    }

    @Test(dataProvider = "getData")
    public void testInvalidLogin(String username, String password) throws InterruptedException {
        bot.navigate("https://opensource-demo.orangehrmlive.com/");
        bot.type(By.name("username"), username);
        bot.type(By.name("password"), password);
        bot.click(By.tagName("button"));

        String expectedErrorMessage = "Invalid credentials";
        Thread.sleep(1000);

        String actualErrorMessage = driver.findElement(By.xpath("//*[.='Invalid credentials']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials");


        //Generate Allure report
        //npx allure-commandline generate --single-file allure-results
    }
}