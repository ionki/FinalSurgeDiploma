package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FullAddWorkout {
    String workoutDate;
    String timeOfDay;
    String workoutName;
    String workoutDescription;
    String distance;
    String duration;
    String pace;
    String caloriesBurned;
}
