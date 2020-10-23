package design_patterns.exercisesGenerator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.DoubleBinaryOperator;

@RequiredArgsConstructor
@Getter
public enum  Operation{

    PLUS(1,"+", Double::sum),
    MINUS(2,"-",(a, b) -> a - b);

    private final int id;
    private final String sign;
    private final DoubleBinaryOperator operator;

    public static Operation findById(int id){
        Operation[] OperationEnums = values();
        for (Operation operation : OperationEnums) {
            if(id == operation.getId()){
                return operation;
            }
        }
        throw new IllegalStateException(id + " not supported");
    }

    @Override
    public String toString() {
        return sign;
    }
}
