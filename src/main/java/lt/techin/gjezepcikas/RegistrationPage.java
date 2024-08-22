package lt.techin.gjezepcikas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {


    @FindBy(css = "input#username")
    private WebElement inputUserName;

    @FindBy(css = "input#password")
    private WebElement inputPassword;


    @FindBy(css = "input#passwordConfirm")
    private WebElement confirmPassword;

    @FindBy(css = "button")
    private WebElement createAccountButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    void setInputUserName(String userName) {
        inputUserName.sendKeys(userName);
    }

    void setInputPassword(String Password) {
        inputPassword.sendKeys(Password);
    }

    void setConfirmPassword(String Password) {
        confirmPassword.sendKeys(Password);
    }

    void clickCreateAccountButton() {
        createAccountButton.click();
    }


}
