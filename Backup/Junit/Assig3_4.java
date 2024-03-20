package Test.Junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Assig3_4 extends Tests {

    @Test
    public void testGoogleSearch() {
        // Go to Google
        driver.get("https://www.google.com/");

        // Locate the search input field
        WebElement searchInput = driver.findElement(By.name("q"));

        // Use Actions to perform keyboard actions
        Actions actions = new Actions(driver);
        actions.moveToElement(searchInput)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("croll")
                .sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethods")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
    }
}