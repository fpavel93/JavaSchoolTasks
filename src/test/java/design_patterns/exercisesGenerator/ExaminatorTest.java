package design_patterns.exercisesGenerator;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ExaminatorTest {

    @Test
    public void getExercises() {
        Examinator examinator = new Examinator(new SimpleExerciseGenerator());//need moko
        List<Exercise> exercises = examinator.getExercises(10);
        Assert.assertEquals(10,exercises.size());
    }
}