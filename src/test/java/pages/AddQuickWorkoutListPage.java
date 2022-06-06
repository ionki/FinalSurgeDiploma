package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class AddQuickWorkoutListPage extends BasePage {

    public static final By QUICK_ADD_BUTTON = By.id("QuickAddToggle");
    //public static final By TITLE = By.id("dpMonth");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert-error");

    public static final By ALERT_MESSAGE = By.className("fc-event-activity-title");


    public AddQuickWorkoutListPage(WebDriver driver) {
        super(driver);
    }


    @Step("Opening calendar page")
    public AddQuickWorkoutListPage open() {
        //log.info("Open Calendar Page {}", baseUrl);
        driver.get(baseUrl + "Calendar.cshtml");
        return this;
    }


    @Step("Click quick add workout on calendar page")
    public AddQuickWorkoutModal clickQuickAddWorkout() {
        //log.info("Click {} in order to open quick add workout", QUICK_ADD_BUTTON);
        driver.findElement(QUICK_ADD_BUTTON).click();
        return new AddQuickWorkoutModal(driver);
    }
    @Step("Getting error from Quick Workout")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getAttribute("innerText");
    }
    @Step("Getting workout on calendar page")
    public String getMessage(){
        return driver.findElement(ALERT_MESSAGE).getAttribute("innerText");
    }

}
