package calc.commands;

import java.util.Map;
import java.util.Stack;

public class MulCmd implements Command {


    @Override
    public void execute(String arg, Stack<Double> stack, Map<String, Double> param) {
        double a, b, c;
        a = Double.valueOf(stack.pop().toString());
        b = Double.valueOf(stack.pop().toString());
        c = a * b;
        stack.push(c);
    }
}
