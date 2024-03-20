package Test.testng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*/
/* Add three different log messages for the task below:
go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */

public class Assig3_5 extends Tests {

    @Test
    public void testLoginWithIncorrectPassword() {
        SoftAssert softAssert = new SoftAssert();

        logger.info("Test: Login with incorrect password started.");
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        logger.info("Entering username.");
        bot.type(By.id("username"), "student");

        logger.info("Entering password.");
        bot.type(By.id("password"), "incorrectPassword");

        logger.info("Clicking login button.");
        bot.click(By.id("submit"));

        // Assuming error message appears within an element identified by this class name.
        String errorMessage = driver.findElement(By.id("error")).getText();

        logger.info("Verifying error message visibility.");
        softAssert.assertTrue(!errorMessage.isEmpty(), "Error message is not displayed.");

        logger.info("Verifying error message content.");
        softAssert.assertEquals(errorMessage, "Your password is invalid!", "Error message content does not match expected.");

        softAssert.assertAll();
        logger.info("Test: Login with incorrect password completed.");
    }
}
