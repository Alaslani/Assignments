package Test.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

/*/
/*
//Go to URL: https://the-internet.herokuapp.com/windows
    //Verify the text: “Opening a new window”1
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”
*/



public class Assig1_4 extends Tests {

    @Test
    public void testWindowHandling() {
        driver.get("https://the-internet.herokuapp.com/windows");

        // Verify the text: “Opening a new window”
        WebElement heading = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assertions.assertEquals("Opening a new window", heading.getText(), "Expected heading text not found.");

        // Verify the title of the page is “The Internet”
        Assertions.assertEquals("The Internet", driver.getTitle(), "Page title is not as expected.");

        // Click on the “Click Here” button
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        // Handle the new window
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        String newWindowHandle = null;
        for (String handle : allWindowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }

        Assertions.assertNotNull(newWindowHandle, "New window handle not found.");
        driver.switchTo().window(newWindowHandle);

        // Verify the new window title is “New Window”
        Assertions.assertEquals("New Window", driver.getTitle(), "New window title is not as expected.");

        // Close the new window and switch back to the original window
        driver.close();
        driver.switchTo().window(originalWindowHandle);

        // Verify the title of the original window is “The Internet”
        Assertions.assertEquals("The Internet", driver.getTitle(), "Original window title is not as expected after returning.");
    }
}