package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkoutPage extends BasePage {

    public WorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening workout page")
    public void open() {
        driver.get(baseUrl + "WorkoutAdd.cshtml");
    }

    @Step("Opening tabs")
    public void tabOpen(String tab) {
        driver.findElement(By.cssSelector("[data-code=" + tab + "]")).click();
    }

    @Step("Filling workout date input: Date - '{date}'")
    public void dateWorkout(String date) {
        driver.findElement(By.id("WorkoutDate")).clear();
        driver.findElement(By.id("WorkoutDate")).sendKeys(date);
    }

    @Step("Filling workout time input: Time - '{time}'")
    public void timeWorkout(String time) {
        driver.findElement(By.id("WorkoutTime")).sendKeys(time);
    }

    @Step("Filling workout name input: Name - '{name}'")
    public void nameWorkout(String name) {
        driver.findElement(By.id("Name")).sendKeys(name);
    }

    @Step("Filling workout description input: Description - '{description}'")
    public void descriptionWorkout(String description) {
        driver.findElement(By.id("Desc")).sendKeys(description);
    }

    @Step("Filling workout distance input: Distance - '{distance}'")
    public void distanceWorkout(String distance) {
        driver.findElement(By.id("Distance")).sendKeys(distance);
        Select select = new Select(driver.findElement(By.id("DistType")));
        select.selectByVisibleText("m");
    }

    @Step("Filling workout distance input: Distance - '{distance}'")
    public void distanceForCrossTrainingWorkout(String distance) {
        driver.findElement(By.id("DistanceNoInt")).sendKeys(distance);
        Select select = new Select(driver.findElement(By.id("DistTypeNoInt")));
        select.selectByVisibleText("m");
    }

    @Step("Filling workout duration input: Duration - '{duration}'")
    public void durationWorkout(String duration) {
        driver.findElement(By.id("Duration")).sendKeys(duration);
    }

    @Step("Filling workout duration input: Duration - '{duration}'")
    public void durationNoIntWorkout(String duration) {
        driver.findElement(By.id("DurationNoInt")).sendKeys(duration);
    }

    @Step("Сhoosing an advanced workout")
    public void advancedWorkout() {
        driver.findElement(By.id("tIntervals")).click();
    }

    @Step("Filling workout reps input: Reps - '{reps}'")
    public void repsOfSetWorkout(String reps) {
        driver.findElement(By.id("SetReps1")).sendKeys(reps);
    }

    @Step("Filling workout distance input: Distance - '{distance}'")
    public void distanceOfSetWorkout(String distance) {
        driver.findElement(By.id("SetDist1")).sendKeys(distance);
    }

    @Step("Filling workout duration input: Duration - '{duration}'")
    public void durationOfSetWorkout(String duration) {
        driver.findElement(By.id("SetTime1")).sendKeys(duration);
    }

    @Step("Filling HR inputs: MinHR - '{minHR}', AvgHR - '{avgHR}', MaxHR - '{maxHR}'")
    public void HRWorkout(String minHR, String avgHR, String maxHR) {
        driver.findElement(By.id("MinHR")).sendKeys(minHR);
        driver.findElement(By.id("AvgHR")).sendKeys(avgHR);
        driver.findElement(By.id("MaxHR")).sendKeys(maxHR);
    }

    @Step("Filling kCal input: KCal - '{kCal}'")
    public void kCalWorkout(String kCal) {
        driver.findElement(By.id("kCal")).sendKeys(kCal);
    }

    @Step("Filling pow inputs: PowAvg - '{kCal}', PowMax - '{powMax}'")
    public void powWorkout(String powAvg, String powMax) {
        driver.findElement(By.id("PowAvg")).sendKeys(powAvg);
        driver.findElement(By.id("PowMax")).sendKeys(powMax);
    }

    @Step("Filling cad inputs: CadAvg - '{cadAvg}', CadMax - '{cadMax}'")
    public void cadWorkout(String cadAvg, String cadMax) {
        driver.findElement(By.id("CadAvg")).sendKeys(cadAvg);
        driver.findElement(By.id("CadMax")).sendKeys(cadMax);
    }

    @Step("Filling Elevation inputs: Elevation Gain - '{EGain}', Elevation Loss - '{ELoss}'")
    public void elevationWorkout(String elevationGain, String elevationLoss) {
        driver.findElement(By.id("EGain")).sendKeys(elevationGain);
        driver.findElement(By.id("ELoss")).sendKeys(elevationLoss);
    }

    @Step("The mark of feelings")
    public void feel(String feel) {
        driver.findElement(By.id("hf_" + feel)).click();
    }

    @Step("The mark of Perceived Effort")
    public void perceivedEffort(String effort) {
        Select select = new Select(driver.findElement(By.id("PerEffort")));
        select.selectByVisibleText(effort);
    }

    @Step("Save button for workout")
    public void saveWorkout() {
        driver.findElement(By.id("saveButton")).click();
    }

    @Step("Search for a workout")
    public boolean getWorkout() {
        return driver.findElement(By.className("dropdown-toggle")).isDisplayed();
    }
}
