package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RegistrationTest extends BaseTest {


    String firstName = RandomDataGenerator.getRandomFirstName();
    String password = RandomDataGenerator.getRandomPassword();


    @Test
    @Tag("Positive")
    void createAccountTest() {

        ConfigUtility.setProperty("firstName", firstName);
        ConfigUtility.setProperty("password", password);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpButton();

        registrationPage.setInputUserName(firstName);
        registrationPage.setInputPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clickCreateAccountButton();

        assertEquals("Skaičiuotuvas", registrationPage.getTitle(),
                "Sign-in page title mismatch");
        String expectedUrl = "http://localhost:8080/skaiciuotuvas";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "Current URL does not match expected URL");

    }

    @Test
    @Tag("Negative")
    void negativeCreateAccountTest() {


        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpButton();

        registrationPage.setInputUserName(firstName);
        registrationPage.setInputPassword(password);
        registrationPage.setConfirmPassword("");
        registrationPage.clickCreateAccountButton();


        assertNotEquals("Skaičiuotuvas", registrationPage.getTitle(),
                "Sign-in page title mismatch");
        String expectedUrl = "http://localhost:8080/registruoti";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "Current URL does not match expected URL");
    }

    @ParameterizedTest
    @Tag("Negative")
    @CsvFileSource(files = "src/test/resources/invalid_first_name_values.csv", numLinesToSkip = 1)
    void registerWithInvalidFirstName(String firstName) {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpButton();

        registrationPage.setInputUserName(firstName);
        registrationPage.setInputPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clickCreateAccountButton();


        assertNotEquals("Skaičiuotuvas", registrationPage.getTitle(),
                "Sign-in page title mismatch");
        String expectedUrl = "http://localhost:8080/registruoti";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "Current URL does not match expected URL");

    }

    @ParameterizedTest
    @Tag("Negative")
    @CsvFileSource(files = "src/test/resources/invalid password.csv", numLinesToSkip = 1)
    void registerWithInvalidPassword(String password) {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpButton();

        registrationPage.setInputUserName(firstName);
        registrationPage.setInputPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.clickCreateAccountButton();


        assertNotEquals("Skaičiuotuvas", registrationPage.getTitle(),
                "Sign-in page title mismatch");
        String expectedUrl = "http://localhost:8080/registruoti";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "Current URL does not match expected URL");

    }

}
