package pages;

import dto.QuickAddWorkout;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class AddQuickWorkoutModal extends BasePage{
    public final static By SAVE_BUTTON = By.id("saveButton");

    public AddQuickWorkoutModal(WebDriver driver) {
        super(driver);
    }

    @Step("Add arguments to Quick Workout")
    public AddQuickWorkoutModal addArgumentsToQuickWorkout(QuickAddWorkout quickAddWorkout) {
        driver.findElement(By.id("WorkoutDate")).clear();
        new Input(driver, "Date").write(quickAddWorkout.getWorkoutDate());
        new Input(driver, "Time of Day").write(quickAddWorkout.getTimeOfDay());
        new DropDown(driver, "Activity Type").select(quickAddWorkout.getActivityType());
        new Input(driver, "Workout Name").write(quickAddWorkout.getWorkoutName());
        new TextArea(driver, "Workout Description").write(quickAddWorkout.getWorkoutDescription());
        new Input(driver, "Distance").write(quickAddWorkout.getDistance());
        new Input(driver, "Duration").write(quickAddWorkout.getDuration());
        driver.findElement(By.id("Pace")).clear();
        new Input(driver, "Pace").write(quickAddWorkout.getPace());
        new TextArea(driver, "Post Workout Notes/Results").write(quickAddWorkout.getPostWorkoutNotesResults());
        return this;
    }
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

}