import calc.commands.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, Command> map = new HashMap<String, Command>();
        Map<String, Double> param = new HashMap<String, Double>();
        map.put("+".trim(), new AddCmd());
        map.put("-".trim(), new SubCmd());
        map.put("*".trim(), new MulCmd());
        map.put("/".trim(), new DivCmd());
        map.put("sqrt".toLowerCase().trim(), new SqrtCmd());
        map.put("print".toLowerCase().trim(), new PrintCmd());
        map.put("push".toLowerCase().trim(), new PushCmd());
        map.put("define".toLowerCase().trim(), new DefineCmd());
        map.put("pop".toLowerCase().trim(), new PopCmd());
        map.put("#".toLowerCase().trim(), new CommentCmd());


        try {
            Stack<Double> stack = new Stack();
            BufferedReader br=null;
            if (args.length>0) {
                br = new BufferedReader(new FileReader(args[0]));
            } else {
                System.out.println("Введите команды для калькулятора: \nДля выхода введите exit");
                br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            }

            String s;
            while ((s = br.readLine()) != null) {
                s = s.trim();
                Double v = 0.;
                String[] str;
                String arg = "";
                str = s.split(" ");
                String c = str[0].toLowerCase().trim();
                if (str.length > 1) {
                    arg = s.substring(str[0].length()).trim();
                }
                if (c.equals("")) {
                    continue;
                }
                if(c.equals("exit")){
                    break;
                }
                if (map.containsKey(c)) {
                    try {
                        map.get(c).execute(arg, stack, param);
                    } catch (EmptyStackException e) {
                        System.out.println("Недостаточно элементов в стеке для команды " + c);
                    }
                } else {
                    System.out.println("Неверный формат команды... " + c);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
