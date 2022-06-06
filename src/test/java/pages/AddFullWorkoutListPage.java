package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddFullWorkoutListPage extends BasePage {

    public static final By FULL_ADD_BUTTON = By.id("FullAddBtn");
    public static final By SELECT_ACTIVITY_TYPE = By.xpath("//a[contains(text(), 'Walk')]/../../div[@class = 'accordion-heading']");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert-error");
    public AddFullWorkoutListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening calendar page")
    public AddFullWorkoutListPage open() {
        //log.info("Open Calendar Page {}", baseUrl);
        driver.get(baseUrl + "Calendar.cshtml");
        return this;
    }
    @Step("Click quick add workout on calendar page")
    public AddFullWorkoutModal clickFullAddWorkout() {
        //log.info("Click {} in order to open quick add workout", FULL_ADD_BUTTON);
        driver.findElement(FULL_ADD_BUTTON).click();
        driver.findElement(SELECT_ACTIVITY_TYPE).click();
        return new AddFullWorkoutModal(driver);
    }

    @Step("Search for a workout")
    public boolean getMessage() {
        return driver.findElement(By.className("dropdown-toggle")).isDisplayed();
    }

    @Step("Getting error from Quick Workout")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getAttribute("innerText");
    }
}
