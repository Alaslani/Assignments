package Test.Junit;


import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;


/*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */
public class Assig5_4 extends Tests {

   @Test
    public void cookieOperations() {
        // Navigate to Facebook
        driver.get("http://facebook.com");

        // Get and print all cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("All Cookies:");
        for (Cookie cookie : allCookies) {
            System.out.println(cookie.getName() + ": " + cookie.getValue());
        }

        // Add a new cookie
        Cookie newCookie = new Cookie("testCookie", "123456789");
        driver.manage().addCookie(newCookie);

        // Verify the new cookie has been added
        Cookie retrievedCookie = driver.manage().getCookieNamed("testCookie");
        System.out.println("Newly added cookie: " + retrievedCookie.getName() + ": " + retrievedCookie.getValue());
        assert retrievedCookie != null : "New cookie was not added successfully";

        // Delete the specific cookie by name
        driver.manage().deleteCookieNamed("testCookie");

        // Verify the cookie has been deleted
        retrievedCookie = driver.manage().getCookieNamed("testCookie");
        assert retrievedCookie == null : "Cookie was not deleted successfully";

        // Delete all cookies
        driver.manage().deleteAllCookies();

        // Verify all cookies are deleted
        allCookies = driver.manage().getCookies();
        assert allCookies.isEmpty() : "Not all cookies were deleted";
    }
}