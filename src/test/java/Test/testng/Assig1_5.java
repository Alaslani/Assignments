package Test.testng;


import org.testng.annotations.*;

/*/
*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
 

public class Assig1_5 extends Tests {
    @Test
    public void testFacebook() {
        logger.info("Navigating to Facebook");
        driver.get("https://www.facebook.com");
        // Add your Facebook test steps here
    }

    @Test(dependsOnMethods = "testFacebook")
    public void testGoogle() {
        logger.info("Navigating to Google");
        driver.get("https://www.google.com");
        // Add your Google test steps here
    }

    @Test(dependsOnMethods = "testGoogle")
    public void testAmazon() {
        logger.info("Navigating to Amazon");
        driver.get("https://www.amazon.com");
        // Add your Amazon test steps here
    }
}