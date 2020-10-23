package design_patterns.exercisesGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Examinator {

    ExerciseGenerator exerciseGenerator;

    public List<Exercise> getExercises(int amount){
        List<Exercise> exercises = new ArrayList<>();
        while (exercises.size() < amount){
            exercises.add(exerciseGenerator.createExercise());
        }
        return exercises;
    }
}
