package calc.commands;

import java.util.Map;
import java.util.Stack;

public class DefineCmd implements Command {


    @Override
    public void execute(String arg, Stack<Double> stack, Map<String, Double> param) {
        String[] s = arg.split(" ");
        param.put(s[0], Double.valueOf(arg.substring(s[0].length()).trim()));
    }
}
