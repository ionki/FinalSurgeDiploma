package tests;

import dto.QuickAddWorkout;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CalendarTest extends BaseTest{


    @Test(description = "Adding correct data", retryAnalyzer = Retry.class)
    public void QuickWorkoutOnCalendarPositiveTest() {
        QuickAddWorkout quickAddWorkout = QuickAddWorkout.builder()
                .workoutDate("06/12/2022")
                .timeOfDay("06:00 AM")
                .activityType("Run")
                .workoutName("Maybe I'll start running")
                .workoutDescription("Smart")
                .distance("5")
                .duration("78:00:43")
                .pace("5:12")
                .postWorkoutNotesResults("I wont run")
                .build();

        loginPage.open();
        loginPage.login(USER, PASSWORD);
        addQuickWorkoutListPage.open();
        addQuickWorkoutListPage.clickQuickAddWorkout();
        addQuickWorkoutModal.addArgumentsToQuickWorkout(quickAddWorkout);
        addQuickWorkoutModal.save();
        String message = addQuickWorkoutListPage.getMessage();
        assertEquals(addQuickWorkoutListPage.getMessage(), message, "Wrong message");
    }
    @Test(description = "Not adding Activity Type data", retryAnalyzer = Retry.class)
    public void QuickWorkoutOnCalendarActivityTypeNegativeTest() {

        QuickAddWorkout quickAddWorkout = QuickAddWorkout.builder()
                .workoutDate("06/12/2022")
                .timeOfDay("06:00 AM")
                .activityType("")
                .workoutName("Maybe I'll start running")
                .workoutDescription("Smart")
                .distance("5")
                .duration("78:00:43")
                .pace("54:12")
                .postWorkoutNotesResults("I wont run")
                .build();

        loginPage.open();
        loginPage.login(USER, PASSWORD);
        addQuickWorkoutListPage.open();
        addQuickWorkoutListPage.clickQuickAddWorkout();
        addQuickWorkoutModal.addArgumentsToQuickWorkout(quickAddWorkout);
        addQuickWorkoutModal.save();
        String error = addQuickWorkoutListPage.getError();
        assertEquals(addQuickWorkoutListPage.getError(), error, "Wrong error message");
    }


    @Test(description = "Not adding Workout Date data", retryAnalyzer = Retry.class)
    public void QuickWorkoutOnCalendarWorkoutDateNegativeTest() {

        QuickAddWorkout quickAddWorkout = QuickAddWorkout.builder()
                .workoutDate("")
                .timeOfDay("06:00 AM")
                .activityType("Run")
                .workoutName("Maybe I'll start running")
                .workoutDescription("Smart")
                .distance("5")
                .duration("78:00:43")
                .pace("54:12")
                .postWorkoutNotesResults("I wont run")
                .build();

        loginPage.open();
        loginPage.login(USER, PASSWORD);
        addQuickWorkoutListPage.open();
        addQuickWorkoutListPage.clickQuickAddWorkout();
        addQuickWorkoutModal.addArgumentsToQuickWorkout(quickAddWorkout);
        addQuickWorkoutModal.save();
        String error = addQuickWorkoutListPage.getError();
        assertEquals(addQuickWorkoutListPage.getError(), error, "Wrong error message");
    }

    @Test(description = "Not adding Pace data", retryAnalyzer = Retry.class)
    public void QuickWorkoutOnCalendarPaceNegativeTest() {

        QuickAddWorkout quickAddWorkout = QuickAddWorkout.builder()
                .workoutDate("06/12/2022")
                .timeOfDay("06:00 AM")
                .activityType("Run")
                .workoutName("Maybe I'll start running")
                .workoutDescription("Smart")
                .distance("5")
                .duration("78:00:43")
                .pace("15:00:56")
                .postWorkoutNotesResults("I wont run")
                .build();

        loginPage.open();
        loginPage.login(USER, PASSWORD);
        addQuickWorkoutListPage.open();
        addQuickWorkoutListPage.clickQuickAddWorkout();
        addQuickWorkoutModal.addArgumentsToQuickWorkout(quickAddWorkout);
        addQuickWorkoutModal.save();
        String error = addQuickWorkoutListPage.getError();
        assertEquals(addQuickWorkoutListPage.getError(), error, "Wrong error message");
    }
}

