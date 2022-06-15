package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CalculatorTest extends BaseTest {


    @Test(description = "Positive test with right inputs on Pace Calculator", retryAnalyzer = Retry.class)
    public void paceCalcPositiveTest() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calculatorPage.open();
        calculatorPage.paceCalc();
        calculatorPage.distanceInput("2000");
        calculatorPage.timeInput("2", "03", "23");
        calculatorPage.saveButton();
        assertTrue(calculatorPage.getPace(), "Pace is calculated");
    }

    @Test(description = "Positive test with right inputs on Caloric Needs Calculator", retryAnalyzer = Retry.class)
    public void caloricNeedsPositiveTest() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calculatorPage.open();
        calculatorPage.weightInput("48");
        calculatorPage.heightInput("168");
        calculatorPage.ageInput("20");
        calculatorPage.femaleGender();
        calculatorPage.runDistance("20");
        calculatorPage.saveButton();
        assertTrue(calculatorPage.getCaloricNeeds(), "Caloric Need is calculated");
    }

    @DataProvider(name = "Incoming data for negative tests in the Caloric Needs calculator")
    public Object[][] caloricNeedsData() {
        return new Object[][]{
                {"", "", "", "", "×\n" + "Please fix the following errors:\n" +
                        "*Please enter an Integer value for Age.\n" + "*Please enter a value for Weight.\n" +
                        "*Please enter a value for Run Distance.\n"},
                {"48", "", "", "", "×\n" + "Please fix the following errors:\n" +
                        "*Please enter an Integer value for Age.\n" +
                        "*Please enter a value for Run Distance.\n"},
                {"48", "", "19", "", "×\n" + "Please fix the following errors:\n" +
                        "*Please enter a value for Run Distance.\n"},
                {"hello", "hello", "hi", "hello","×\n" + "Please fix the following errors:\n" +
                        "*Please enter a valid Integer for Age (no decimals).\n" +
                        "*Please enter a valid Weight.\n" +
                        "*Please enter a valid Run Distance.\n"},
                {"1", "", "1", "100", "×\n" + "Please fix the following errors:\n" +
                        "*Age cannot be less than 5.\n" +
                        "*Weight cannot be less than 30.00.\n"},
                {"30", "", "5", "100", "×\n" + "Please fix the following errors:\n" +
                        "*Please enter a value for Height in Centimeters.\n"},
                {"30", "12", "5", "100", "×\n" + "Please fix the following errors:\n" +
                        "*Height in Centimeters cannot be less than 60.00.\n"},

        };
    }

    @Test(dataProvider = "Incoming data for negative tests in the Caloric Needs calculator",retryAnalyzer = Retry.class)
    public void inputsForCaloricNeedsCalcShouldBeRequired(String weight, String height, String age, String distance, String error) {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calculatorPage.open();
        calculatorPage.weightInput(weight);
        calculatorPage.heightInput(height);
        calculatorPage.ageInput(age);
        calculatorPage.femaleGender();
        calculatorPage.runDistance(distance);
        calculatorPage.saveButton();
        assertEquals(calculatorPage.getError(), error, "Wrong error message");
    }

    @DataProvider(name = "Incoming data for negative tests in the Pace calculator")
    public Object[][] paceData() {
        return new Object[][]{
                {"", "", "", "", "×\nPlease fix the following errors:\n" +
                        "*Please enter an Integer value for Minutes.\n"},
                {"0", "0", "0", "0", "×\nPlease fix the following errors:\n" +
                        "*Please enter a distance greater than 0.\n" +
                        "*Please enter a time greater than 0 seconds.\n"},
                {"test", "hi", "hi", "hi", "×\nPlease fix the following errors:\n" +
                        "*Please enter a valid Integer for Hours (no decimals).\n" +
                        "*Please enter a valid Integer for Minutes (no decimals).\n" +
                        "*Please enter a valid Integer for Seconds (no decimals).\n"},
        };
    }

    @Test(dataProvider = "Incoming data for negative tests in the Pace calculator", retryAnalyzer = Retry.class)
    public void inputsForPaceCalcShouldBeRequired(String distance, String hours, String minutes, String seconds, String error) {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calculatorPage.open();
        calculatorPage.paceCalc();
        calculatorPage.distanceInput(distance);
        calculatorPage.timeInput(hours, minutes, seconds);
        calculatorPage.saveButton();
        assertEquals(calculatorPage.getError(), error, "Wrong error message");
    }
}