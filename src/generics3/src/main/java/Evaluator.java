import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

    public BiFunction<Boolean, Boolean, Boolean> xor_gate() {
        return (a, b) -> {
            if(a){
                if(b){
                    return false;
                }
                return true;
            } else if (b) {
                return true;
            } else {
                return false;
            }
        };
    }

    public BiFunction<Boolean, Boolean, Boolean> or_gate() {
        return (aBoolean, aBoolean2) -> {
            if(aBoolean){
                return true;
            } else if (aBoolean2) {
                return true;
            } else {
                return false;
            }
        };
    }

    public BiFunction<Boolean, Boolean, Boolean> and_gate() {
        return (aBoolean, aBoolean2) -> {
            if(aBoolean){
                return aBoolean2;
            } else{
                return false;
            }
        };
    }

    public Function<Boolean, Boolean> not_gate() {
        return (b)->{
            if(b){
                return false;
            }else{
                return true;
            }
        };
    }

    // Should return a map containing the computation's results (use HashMap)
    // You're asked to store the results under the following keys: "SUM" & "carry_out"
    // TODO WARNING : ONLY USE the previously defined methods to compute the result
    // (INGInious will prevent you from cheating by directly invoking logical operators)
    public Map<String, Boolean> evaluate_circuit(Boolean a, Boolean b, Boolean carry_in) {
        HashMap<String,Boolean> result = new HashMap<>();
        boolean step1 = xor_gate().apply(a,b);
        boolean step21 = and_gate().apply(step1,carry_in);
        boolean step22 = and_gate().apply(a,b);
        boolean sum = xor_gate().apply(step1,carry_in);
        boolean carry_out = or_gate().apply(step21,step22);
        result.put("SUM",sum);
        result.put("carry_out", carry_out);
        return result;
    }

}