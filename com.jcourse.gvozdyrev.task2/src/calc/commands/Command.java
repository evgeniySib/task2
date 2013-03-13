package calc.commands;

import java.util.Map;
import java.util.Stack;

public interface Command {

    void execute(String arg, Stack<Double> stack, Map<String, Double> param);
}
