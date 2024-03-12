package Test.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assig2_4 extends Tests {

    @Test
    public void testDragAndDrop() {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        Actions action = new Actions(driver);

        // Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement fromBank = driver.findElement(By.xpath("//li[@id='credit2']"));
        WebElement toDebitAccount = driver.findElement(By.xpath("//ol[@id='bank']"));
        action.dragAndDrop(fromBank, toDebitAccount).perform();

        // Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement fromSales = driver.findElement(By.xpath("//li[@id='credit1']"));
        WebElement toCreditAccount = driver.findElement(By.xpath("//ol[@id='loan']"));
        action.dragAndDrop(fromSales, toCreditAccount).perform();

        // Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement fromAmount5000Debit = driver.findElement(By.xpath("//li[@id='fourth']"));
        WebElement toDebitAmount = driver.findElement(By.xpath("//ol[@id='amt7']"));
        action.dragAndDrop(fromAmount5000Debit, toDebitAmount).perform();

        // Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement fromAmount5000Credit = driver.findElement(By.xpath("//li[@id='fourth']"));
        WebElement toCreditAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));
        action.dragAndDrop(fromAmount5000Credit, toCreditAmount).perform();

        // Verify the visibility of "Perfect" text
        WebElement perfectText = driver.findElement(By.xpath("//div[@id='equal']"));
        ((WebDriverWait)wait).until(ExpectedConditions.visibilityOf(perfectText));
        Assertions.assertTrue(perfectText.isDisplayed(), "'Perfect' text is not visible.");


    }
}