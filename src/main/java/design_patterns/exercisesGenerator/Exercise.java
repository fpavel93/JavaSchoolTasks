package design_patterns.exercisesGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    private double a;
    private double b;
    private  double answer;
    private Operation operation;
}
