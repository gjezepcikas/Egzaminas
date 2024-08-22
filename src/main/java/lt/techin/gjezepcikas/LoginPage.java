package lt.techin.gjezepcikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(css = "a")
    private WebElement clickSignUp;

    @FindBy(css = "input[name='username']")
    private WebElement inputLoginName;

    @FindBy(css = "input[name='password']")
    private WebElement inputLoginPassword;

    @FindBy(css = ".btn.btn-block.btn-lg.btn-primary")
    private WebElement loginButton;

    @FindBy(css = "[onclick]")
    private WebElement loggedIn;



    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickSignUpButton() {
        clickSignUp.click();
    }

    public void inputLoginName(String loginName) {
        inputLoginName.sendKeys(loginName);
    }

    public void inputLoginPassword(String password) {
        inputLoginPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String loggedIn(){

        return loggedIn.getText();
    }

    public String loginErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".form-group span:nth-child(4)"))).getText();
    }



}
