package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage extends BasePage {

    public static final By ERROR_MESSAGE = By.cssSelector(".alert-error");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening calculator")
    public void open() {
        driver.get(baseUrl + "Calendar.cshtml");
        driver.findElement(By.xpath("//i[@class = 'icsw16-calculator']")).click();
        driver.switchTo().frame("OtherCalciFrame");
    }

    @Step("Choosing pace calculator")
    public void paceCalc() {
        driver.findElement(By.xpath("//a[contains(text(),'Pace Calculator')]")).click();
    }

    @Step("Filling distance input")
    public void distanceInput(String distance) {
        driver.findElement(By.id("RunDist")).sendKeys(distance);
    }

    @Step("Filling time input")
    public void timeInput(String hours, String minutes, String seconds) {
        driver.findElement(By.id("TimeHH")).sendKeys(hours);
        driver.findElement(By.id("TimeMM")).sendKeys(minutes);
        driver.findElement(By.id("TimeSS")).sendKeys(seconds);
    }

    @Step("Filling distance input")
    public void saveButton() {
        driver.findElement(By.id("saveButtonSettings")).click();
    }

    @Step("Search for a pace")
    public boolean getPace() {
        return driver.findElement(By.xpath("//*[@class='w-box-header']//*[text()='Pace Chart']")).isDisplayed();
    }

    @Step("Search for a pace")
    public boolean getCaloricNeeds() {
        return driver.findElement(By.xpath("//*[@class='w-box-header']//*[text()='Daily Caloric Needs Calculator']")).isDisplayed();
    }

    @Step("Filling weight input")
    public void weightInput(String weight) {
        driver.findElement(By.id("Weight")).sendKeys(weight);
        driver.findElement(By.id("optionsRadios4")).click();
    }

    @Step("Filling height input")
    public void heightInput(String height) {
        driver.findElement(By.id("HeightInchCent")).sendKeys(height);
        driver.findElement(By.cssSelector("[value=m]")).click();
    }

    @Step("Filling age input")
    public void ageInput(String age) {
        driver.findElement(By.id("Age")).sendKeys(age);
    }

    @Step("Сhoosing female gender")
    public void femaleGender() {
        driver.findElement(By.id("optionsRadios6")).click();
    }

    @Step("Сhoosing male gender")
    public void maleGender() {
        driver.findElement(By.id("optionsRadios5")).click();
    }

    @Step("Filling run distance input")
    public void runDistance(String distance) {
        driver.findElement(By.id("RunDist")).sendKeys(distance);
        driver.findElement(By.id("optionsRadios8")).click();
    }

    @Step("Getting error from caloric needs calculator")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getAttribute("innerText");
    }
}