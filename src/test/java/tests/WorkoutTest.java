package tests;


import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class WorkoutTest extends BaseTest {

    @Test(description = "Adding a running workout with correct data", retryAnalyzer = Retry.class)
    public void addRunWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("run");
        workoutPage.timeWorkout("15:00");
        workoutPage.nameWorkout("Run");
        workoutPage.descriptionWorkout("Running in the park");
        workoutPage.distanceWorkout("3000");
        workoutPage.durationWorkout("01:19:06");
        workoutPage.feel("great");
        workoutPage.perceivedEffort("8 (Hard)");
        workoutPage.HRWorkout("100", "120", "140");
        workoutPage.kCalWorkout("300");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }


    @Test(description = "Adding a swimming workout with correct data", retryAnalyzer = Retry.class)
    public void addSwimWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("swim");
        workoutPage.dateWorkout("5/25/2022");
        workoutPage.timeWorkout("15:30");
        workoutPage.nameWorkout("Swim");
        workoutPage.descriptionWorkout("Swimming in the pool");
        workoutPage.advancedWorkout();
        workoutPage.repsOfSetWorkout("5");
        workoutPage.distanceOfSetWorkout("500");
        workoutPage.durationOfSetWorkout("20:00");
        workoutPage.feel("normal");
        workoutPage.perceivedEffort("9 (Very Hard)");
        workoutPage.kCalWorkout("200");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Adding a Cross Training workout with correct data", retryAnalyzer = Retry.class)
    public void addCrossTrainingWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("cross-trai");
        workoutPage.dateWorkout("5/13/2022");
        workoutPage.timeWorkout("12:00");
        workoutPage.nameWorkout("Cross");
        workoutPage.descriptionWorkout("Cross in the park");
        workoutPage.distanceForCrossTrainingWorkout("3500");
        workoutPage.durationNoIntWorkout("00:10:00");
        workoutPage.feel("poor");
        workoutPage.perceivedEffort("10 (Max Effort)");
        workoutPage.HRWorkout("100", "120", "140");
        workoutPage.kCalWorkout("300");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Adding a walking workout with correct data", retryAnalyzer = Retry.class)
    public void addWalkWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("walk");
        workoutPage.dateWorkout("5/25/2022");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("Walk");
        workoutPage.descriptionWorkout("Walk on the streets");
        workoutPage.distanceWorkout("5500");
        workoutPage.durationWorkout("00:10:00");
        workoutPage.elevationWorkout("400", "500");
        workoutPage.feel("terrible");
        workoutPage.perceivedEffort("1 (Very Light)");
        workoutPage.powWorkout("100", "200");
        workoutPage.cadWorkout("120", "150");
        workoutPage.HRWorkout("100", "120", "140");
        workoutPage.kCalWorkout("300");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Adding a rest day with correct data", retryAnalyzer = Retry.class)
    public void addRestDayWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("rest");
        workoutPage.dateWorkout("5/24/2022");
        workoutPage.nameWorkout("Rest");
        workoutPage.descriptionWorkout("Resting");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Adding a Strength Training workout with correct data", retryAnalyzer = Retry.class)
    public void addStrengthTrainingWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("strength-t");
        workoutPage.dateWorkout("5/23/2022");
        workoutPage.timeWorkout("15:30");
        workoutPage.nameWorkout("Strength Training");
        workoutPage.descriptionWorkout("Strength Training in the gym");
        workoutPage.durationNoIntWorkout("01:50:00");
        workoutPage.feel("great");
        workoutPage.perceivedEffort("6 (Moderate)");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Adding a Recovery with correct data", retryAnalyzer = Retry.class)
    public void addRecoveryWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("recovery");
        workoutPage.dateWorkout("5/22/2022");
        workoutPage.timeWorkout("16:30");
        workoutPage.nameWorkout("Recovery");
        workoutPage.descriptionWorkout("Recovery");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Adding a Other Workout with correct data", retryAnalyzer = Retry.class)
    public void addOtherWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("other");
        workoutPage.dateWorkout("5/29/2022");
        workoutPage.timeWorkout("19:00");
        workoutPage.nameWorkout("Stretching");
        workoutPage.descriptionWorkout("Stretching");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }
}