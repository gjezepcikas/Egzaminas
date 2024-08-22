package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest extends BaseTest {


    String numberOne = RandomDataGenerator.getRandomNumberOne();
    String numberTwo = RandomDataGenerator.getRandomNumberTwo();
    String randomOperand = RandomDataGenerator.getRandomOperand();
    String randomNegative = RandomDataGenerator.getRandomNegative();


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
        calculatorPage.operandsInDropDown(randomOperand);
        calculatorPage.submitButton();

        assertEquals("http://localhost:8080/skaiciuoti", driver.getCurrentUrl(), "Expected URL and current URL doesn't match!!!");
        assertEquals("Skaičiuoti", loginPage.getTitle(),
                "Calculator page title mismatch");
    }


    @Test
    @Tag("Negative")
    public void negativeCalculationTest() {

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
        calculatorPage.inputOne(numberTwo);
        calculatorPage.inputTwo(randomNegative);
        calculatorPage.operandsInDropDown(randomOperand);
        calculatorPage.submitButton();

        assertEquals("Validacijos klaida: skaičius negali būti neigiamas", calculatorPage.errorMessage());
        assertEquals("Skaičiuotuvas", loginPage.getTitle(),
                "Calculator page title mismatch");


    }

}
