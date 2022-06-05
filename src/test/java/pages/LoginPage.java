package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By USER_INPUT = By.id("login_name");
    public static final By PASSWORD_INPUT = By.id("login_password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public void open() {
        driver.get(baseUrl + "login.cshtml");
    }

    @Step("Login by user {user} using password {password}")
    public void login(String user, String password) {
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(PASSWORD_INPUT).submit();
    }
}