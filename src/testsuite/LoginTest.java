package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Finding the username field element
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        // Finding the password field element
        WebElement passwordField = driver.findElement(By.name("txtPassword"));
        // sending Password to password field element
        passwordField.sendKeys("admin123");
        // Finding the login button and clicking on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        //Verify the given text from the requirements
        String expectedTextMessage = "Welcome";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//a[@id='welcome']"));
        //Getting the text by using get method
        String actualTextMessage = actualTextMessageElement.getText();
        //Using substring method
        String actualString = actualTextMessage.substring(0,7);
        //Validate expected and actual text message
        Assert.assertEquals("Unable to navigate to dashboard",expectedTextMessage,actualString);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
