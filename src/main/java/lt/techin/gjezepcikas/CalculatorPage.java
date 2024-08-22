package lt.techin.gjezepcikas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalculatorPage extends BasePage {

    @FindBy(css = "[name='sk1']")
    private WebElement inputOne;

    @FindBy(css = "[name='sk2']")
    private WebElement inputTwo;

    @FindBy(css = "form#number > select[name='zenklas']")
    private WebElement operandDropDown;

    @FindBy(css = "")
    private WebElement chooseFromDropDown;

    @FindBy
    private <List>


    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void inputOne (String numberOne){
        inputOne.click();
        inputOne.sendKeys(numberOne);
    }

    public void inputTwo (String numberTwo){
        inputTwo.click();
        inputTwo.sendKeys(numberTwo);
    }

    public void operandDropDown (){
        inputOne.click();
        inputOne.sendKeys();
    }
    public void submitButton (){
        inputOne.click();
    }


}
