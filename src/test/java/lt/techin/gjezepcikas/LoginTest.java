package lt.techin.gjezepcikas;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginTest extends BaseTest {


    @Test
    @Tag("Positive")
    public void loginWithValidCredentialsTest() {
        String firstName = ConfigUtility.getProperty("firstName");
        String password = ConfigUtility.getProperty("password");


        assertNotNull(firstName, "First name is null");
        assertNotNull(password, "Password is null");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputLoginName(firstName);
        loginPage.inputLoginPassword(password);
        loginPage.clickLoginButton();

        assertEquals("Logout, " + firstName, loginPage.loggedIn());
        assertEquals("Skaičiuotuvas", loginPage.getTitle(), "Login page title mismatch");

    }

    @ParameterizedTest
    @Tag("Negative")
    @CsvFileSource(files = "src/test/resources/invalid password.csv", numLinesToSkip = 1)
    void loginWithInvalidPassword(String password) {

        String firstName = ConfigUtility.getProperty("firstName");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLoginName(firstName);
        loginPage.inputLoginPassword(password);
        loginPage.clickLoginButton();

        assertEquals("http://localhost:8080/prisijungti?error", driver.getCurrentUrl(), "Expected URL and current URL doesn't match!!!");
        assertEquals("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi",loginPage.loginErrorMessage());

    }

    @ParameterizedTest
    @Tag("Negative")
    @CsvFileSource(files = "src/test/resources/invalid_first_name_values.csv", numLinesToSkip = 1)
    void loginWithInvalidLoginName(String loginName) {

        String firstName = ConfigUtility.getProperty("firstName");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLoginName(firstName);
        loginPage.inputLoginPassword(loginName);
        loginPage.clickLoginButton();

        assertEquals("http://localhost:8080/prisijungti?error", driver.getCurrentUrl(), "Expected URL and current URL doesn't match!!!");
        assertEquals("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi",loginPage.loginErrorMessage());

    }

}