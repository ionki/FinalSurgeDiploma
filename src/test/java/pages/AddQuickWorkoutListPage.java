package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class AddQuickWorkoutListPage extends BasePage {

    public static final By QUICK_ADD_BUTTON = By.id("QuickAddToggle");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert-error");
    public static final By ALERT_MESSAGE = By.className("fc-event-activity-title");

    public AddQuickWorkoutListPage(WebDriver driver) {
        super(driver);
    }


    @Step("Opening calendar page")
    public AddQuickWorkoutListPage open() {
        log.info("Open calendar page {}", baseUrl);
        driver.get(baseUrl + "Calendar.cshtml");
        return this;
    }


    @Step("Click quickAdd workout on calendar page")
    public AddQuickWorkoutModal clickQuickAddWorkout() {
        log.info("Click {} in order to open quick add workout", QUICK_ADD_BUTTON);
        driver.findElement(QUICK_ADD_BUTTON).click();
        return new AddQuickWorkoutModal(driver);
    }
    @Step("Getting error from Quick Workout")
    public String getError() {
        log.info("Getting error from Quick Workout");
        return driver.findElement(ERROR_MESSAGE).getAttribute("innerText");
    }
    @Step("Getting workout on calendar page")
    public String getMessage(){
        log.info("Getting workout on calendar page");
        return driver.findElement(ALERT_MESSAGE).getAttribute("innerText");
    }

}
