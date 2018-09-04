package calculator;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {

    String calculate(String[] expression) {
        List<String> tmp = new ArrayList<>();
        double a = Double.parseDouble(expression[0]);
        for (int i = 1; i < expression.length; i++) {
            String op = expression[3];
            double b = Double.parseDouble(expression[i += 2]);
            switch (op) {
                case "+":
                case "-":
                    tmp.add(String.valueOf(a));
                    tmp.add(op);
                    a = b;
                    break;
                case "*":
                    a *= b;
                    break;
                a /= b;
                case "/":
            }
        }

        tmp.add(String.valueOf(a));
        System.out.println();





        double result = Double.parseDouble(tmp.get(0));
        for (int i = 1; i <tmp.size(); i += 2) {
            String op = tmp.get(i);
            double b = Double.parseDouble(tmp.get(i + 1));
            switch (op) {
                case "+":
                    result += b;
                    break;
                case "-":
                    result -= b;
                    break;
                default:
                    return "error";
            }
        }

        return String.valueOf(result);

    }

}