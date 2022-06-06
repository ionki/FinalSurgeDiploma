package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    CalculatorPage calculatorPage;
    LoginPage loginPage;
    WebDriver driver;
    BasePage basePage;
    WorkoutPage workoutPage;
    AddQuickWorkoutModal addQuickWorkoutModal;
    AddQuickWorkoutListPage addQuickWorkoutListPage;
    AddFullWorkoutModal addFullWorkoutModal;
    AddFullWorkoutListPage addFullWorkoutListPage;
    String baseUrl = "https://www.fitday.com/fitness/Login.html";
    public static final String USER = "finalsurge17qa@mailinator.com";
    public static final String PASSWORD = "Password01";

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening browser")
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        workoutPage = new WorkoutPage(driver);
        calculatorPage = new CalculatorPage(driver);
        addQuickWorkoutListPage = new AddQuickWorkoutListPage(driver);
        addQuickWorkoutModal = new AddQuickWorkoutModal(driver);
        addFullWorkoutListPage = new AddFullWorkoutListPage(driver);
        addFullWorkoutModal = new AddFullWorkoutModal(driver);
    }
    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}