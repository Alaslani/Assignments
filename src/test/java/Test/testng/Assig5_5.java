package Test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
/*/
//Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
 */
public class Assig5_5 extends Tests {

    @Test
    public void toDoListTest() {
        bot.navigate("http://crossbrowsertesting.github.io/");

        // Click to To-Do App
        bot.click(By.xpath("//a[@href='todo-app.html']"));

        // Check Todo-4 and Todo-5
        bot.click(By.name("todo-4"));
        bot.click(By.name("todo-5"));

        // Assert that two items are checked
        List<WebElement> doneList = driver.findElements(By.xpath("//span[@class='done-true']"));

        Assert.assertEquals(doneList.size(), 2, "3 of 5 remaining");
        // Archiving checked items
        bot.click(By.xpath("//a[@ng-click='todoList.archive()']"));


        // Assert the list size after archiving
        List<WebElement> checkbox = driver.findElements(By.xpath("//span[@class='done-false']"));
        Assert.assertEquals(checkbox.size(), 3, "3 of 3 remaining");

    }
}
