package tests;

import dto.FullAddWorkout;
import dto.QuickAddWorkout;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalendarTest extends BaseTest{
    @Test
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
        //String error = addQuickWorkoutListPage.getError();
        //assertEquals(calculatorPage.getError(), error, "Wrong error message");
    }
    @Test
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
        assertEquals(calculatorPage.getError(), error, "Wrong error message");
    }





    @Test
    public void fullAddWorkoutOnCalendarPositiveTest(){
        FullAddWorkout fullAddWorkout = FullAddWorkout.builder()
                .workoutDate("08/12/2022")
                .timeOfDay("06:00 AM")
                .workoutName("Walking")
                .workoutDescription("Very smart")
                .distance("10")
                .duration("18:05:43")
                .pace("32:12")
                .caloriesBurned("340")
                .build();

        loginPage.open();
        loginPage.login(USER,PASSWORD);
        addFullWorkoutListPage.open();
        addFullWorkoutListPage.clickFullAddWorkout();
        addFullWorkoutModal.addArgumentsToFullWorkout(fullAddWorkout);
        addFullWorkoutModal.save();
        String error = addFullWorkoutListPage.getError();
        assertEquals(calculatorPage.getError(), error, "Wrong error message");
    }
}

