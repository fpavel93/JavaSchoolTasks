package design_patterns.exercisesGenerator;

import design_patterns.heroesGame.RandomUtil;

public class SimpleExerciseGenerator implements ExerciseGenerator {
    @Override
    public Exercise createExercise() {
        Exercise exercise = new Exercise();
        exercise.setA(RandomUtil.getRandomInRange(0,10));
        exercise.setB(RandomUtil.getRandomInRange(0,10));
        exercise.setOperation(Operation.findById(RandomUtil.getRandomInRange(1,2)));
        exercise.setAnswer(exercise.getOperation().getOperator().applyAsDouble(exercise.getA(),exercise.getB()));
        return exercise;
    }
}
