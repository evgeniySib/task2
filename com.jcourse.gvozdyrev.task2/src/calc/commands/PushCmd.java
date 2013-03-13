package calc.commands;

import java.util.Map;
import java.util.Stack;

public class PushCmd implements Command {


    @Override
    public void execute(String arg, Stack<Double> stack, Map<String, Double> param) {
        stack.push(param.get(arg));
    }


}
