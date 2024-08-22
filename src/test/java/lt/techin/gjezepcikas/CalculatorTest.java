package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends BaseTest{


    String numberOne = RandomDataGenerator.getRandomNumberOne();
    String numberTwo = RandomDataGenerator.getRandomNumberTwo();


    @Test
    @Tag("Positive")
    public void calculationTest() {

        //Login
        String firstName = ConfigUtility.getProperty("firstName");
        String password = ConfigUtility.getProperty("password");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputLoginName(firstName);
        loginPage.inputLoginPassword(password);
        loginPage.clickLoginButton();

        assertEquals("Logout, " + firstName, loginPage.loggedIn());
        assertEquals("Skaičiuotuvas", loginPage.getTitle(), "Login page title mismatch");

        //Calculator

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.inputOne(numberOne);
        calculatorPage.inputTwo(numberTwo);
        calculatorPage.operandDropDown();
        calculatorPage.submitButton();


    }




}
