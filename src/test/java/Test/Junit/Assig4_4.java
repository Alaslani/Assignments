package Test.Junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot;
import java.awt.event.KeyEvent;
/*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
public class Assig4_4 extends Tests {

    @Test
    public void performActionsOnAmazon() throws Exception {
        driver.get("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");

        // Scroll to the bottom of the page using Robot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);

        // Wait a moment for the page to scroll
        Thread.sleep(2000); // Consider using WebDriverWait here for better practice

        // Click on the "Back to top" link
        WebElement backToTopLink = driver.findElement(By.id("navBackToTop"));
        backToTopLink.click();

        // Click on the Amazon logo at the bottom of the page using JavascriptExecutor
        WebElement amazonLogo = driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", amazonLogo);

        // Use Actions to type "ClarusWay" in the search box and perform the search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        new Actions(driver)
                .moveToElement(searchBox)
                .click()
                .sendKeys("ClarusWay")
                .sendKeys(Keys.RETURN)
                .build()
                .perform();
    }
}