package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageElements {

    public LoginPageElements(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='Email']")
    public WebElement emailInput;

    @FindBy(css = "input[name='Password']")
    public WebElement passInput;

    @FindBy(css = "input[value='Log in']")
    public WebElement getLoginButton;

    @FindBy(xpath = "//a[text()='omenoo@mailinator.com']")
    public WebElement loginVerificationEmail;

    @FindBy(xpath = "//span[text()='Login was unsuccessful. Please correct the errors and try again.']")
    public WebElement loginNegativeWarning;

    @FindAll({@FindBy(css = "input[value='Add to cart']") })
    public List<WebElement> productList;

    @FindBy(id = "add-to-cart-button-2")
    public WebElement addToCart;

    @FindBy(css = "input[class='recipient-name']")
    public WebElement recipientName;

    @FindBy(css = "input[class='recipient-email']")
    public WebElement recipientEmail;

    @FindBy(xpath = "//*[text()='The product has been added to your ']")
    public WebElement successMessage;

}
