package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class QuickAddWorkout {
    String workoutDate;
    String timeOfDay;
    String activityType;
    String workoutName;
    String workoutDescription;
    String distance;
    String duration;
    String pace;
    String postWorkoutNotesResults;
}

