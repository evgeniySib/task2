package calc.commands;

import java.util.Map;
import java.util.Stack;

public class SqrtCmd implements Command {
    @Override
    public void execute(String arg, Stack<Double> stack, Map<String, Double> param) {
        double a, b;
        a = Double.valueOf(stack.pop().toString());
        b = Math.sqrt(a);
        stack.push(b);
    }
}
