package pages;

import dto.FullAddWorkout;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.TextArea;

public class AddFullWorkoutModal extends BasePage{

    public static final By SAVE_BUTTON = By.id("saveButton");
    public AddFullWorkoutModal(WebDriver driver) {
        super(driver);
    }

    @Step("Add arguments to Full Workout")
    public AddFullWorkoutModal addArgumentsToFullWorkout(FullAddWorkout fullAddWorkout) {
        driver.findElement(By.id("WorkoutDate")).clear();
        new Input(driver, "Date").write(fullAddWorkout.getWorkoutDate());
        new Input(driver, "Time of Day").write(fullAddWorkout.getTimeOfDay());
        new Input(driver, "Workout Name").write(fullAddWorkout.getWorkoutName());
        new TextArea(driver, "Workout Description").write(fullAddWorkout.getWorkoutDescription());
        new Input(driver, "Distance").write(fullAddWorkout.getDistance());
        new Input(driver, "Duration").write(fullAddWorkout.getDuration());
        new Input(driver, "Pace").write(fullAddWorkout.getPace());
        new Input(driver,"Calories Burned").write(fullAddWorkout.getCaloriesBurned());
        return this;
    }
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
