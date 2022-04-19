package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //Finding the register link element and click on register link
        WebElement forgotYourPasswordLink = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotYourPasswordLink.click();

        // Verifying the text 'Forgot Your Password?' from the given requirements
        String expectedMessage = "Forgot Your Password?";
        // Finding the given text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualMessage = actualMessageElement.getText();
        //Validate expected and actual message
        Assert.assertEquals("Redirects to reset password page", expectedMessage,actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
