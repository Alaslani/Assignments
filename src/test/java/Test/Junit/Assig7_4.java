package Test.Junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Assig7_4 extends Tests {

    @Test
    public void takeAmazonScreenshots() throws IOException {
        driver.get("https://www.amazon.com");

        // Taking a full-page screenshot
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File fullPageDestFile = new File("fullPageScreenshot.png");
        org.openqa.selenium.io.FileHandler.copy(fullPageScreenshot, fullPageDestFile);
        System.out.println("Full page screenshot saved: " + fullPageDestFile.getAbsolutePath());

        // Taking a screenshot of a specific WebElement, e.g., Amazon's logo
        WebElement amazonLogo = driver.findElement(By.xpath("//i[@class='a-icon a-logo']"));
        File logoScreenshot = amazonLogo.getScreenshotAs(OutputType.FILE);
        File logoDestFile = new File("amazonLogoScreenshot.png");
        org.openqa.selenium.io.FileHandler.copy(logoScreenshot, logoDestFile);
        System.out.println("WebElement (Amazon Logo) screenshot saved: " + logoDestFile.getAbsolutePath());
    }
}