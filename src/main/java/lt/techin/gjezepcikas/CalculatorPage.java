package lt.techin.gjezepcikas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CalculatorPage extends BasePage {

    @FindBy(css = "[name='sk1']")
    private WebElement inputOne;

    @FindBy(css = "[name='sk2']")
    private WebElement inputTwo;

    @FindBy(css = "[name='zenklas']")
    private WebElement operandDropDown;


    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "span#sk2\\.errors")
    private WebElement errorMessage;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void inputOne(String numberOne) {
        inputOne.click();
        inputOne.clear();
        inputOne.sendKeys(numberOne);
    }

    public void inputTwo(String numberTwo) {
        inputTwo.click();
        inputTwo.clear();
        inputTwo.sendKeys(numberTwo);
    }

    public void operandDropDown() {
        inputOne.click();
    }

    public void submitButton() {
        submitButton.click();
    }

    public void operandsInDropDown(String randomOperand) {
        operandDropDown.click();
        operandDropDown.sendKeys(randomOperand);
    }

    public String errorMessage() {
        return errorMessage.getText();
    }

}

