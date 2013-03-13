package calc.commands;

import java.util.Map;
import java.util.Stack;

public class PopCmd implements Command {


    @Override
    public void execute(String arg, Stack<Double> stack, Map<String, Double> param) {
        stack.pop();
    }
}
