package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;

    @Test(priority = 1)
    @Parameters({"email","passwd"})
    public void loginFunctionalPositiveTest(String email, String passwd){

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.loginButton));
        homePageElements.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.emailInput));
        loginPageElements.emailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.passInput));
        loginPageElements.passInput.sendKeys(passwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.getLoginButton));
        loginPageElements.getLoginButton.click();

        wait.until(ExpectedConditions.visibilityOf(loginPageElements.loginVerificationEmail));

        Assert.assertEquals(loginPageElements.loginVerificationEmail.getText(), email,"Login Failed");
        System.out.println("Successfully logged in!");
    }

    @Test(priority = 2)
    @Parameters({"email","passwd"})
    public void loginFunctionalNegativeTest(String email, String passwd){

        String warning = "Login was unsuccessful. Please correct the errors and try again.";
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.loginButton));
        homePageElements.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.emailInput));
        loginPageElements.emailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.passInput));
        loginPageElements.passInput.sendKeys(passwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.getLoginButton));
        loginPageElements.getLoginButton.click();

        wait.until(ExpectedConditions.visibilityOf(loginPageElements.loginNegativeWarning));

        Assert.assertEquals(loginPageElements.loginNegativeWarning.getText(), warning,"Check Login negative test warning");
        System.out.println("Negative Test Passed!");
    }

    @Test(priority = 3)
    @Parameters({"email","passwd"})
    public void placeAnOrder(String email, String passwd){

        String warning = "The product has been added to your shopping cart";
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.loginButton));
        homePageElements.loginButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.emailInput));
        loginPageElements.emailInput.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.passInput));
        loginPageElements.passInput.sendKeys(passwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.getLoginButton));
        loginPageElements.getLoginButton.click();

        int rnd = (int)(Math.random()* loginPageElements.productList.size());
        for(WebElement e: loginPageElements.productList){
            loginPageElements.productList.get(rnd);
            e.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.recipientName));
        loginPageElements.recipientName.sendKeys(passwd.substring(0,5));
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.recipientEmail));
        loginPageElements.recipientEmail.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.addToCart));
        loginPageElements.addToCart.click();

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.successMessage));
        String messageText = loginPageElements.successMessage.getText();



        Assert.assertEquals(messageText, warning,"Check Login place order test warning");
        System.out.println("Place An Order Test Passed!");
    }


}
