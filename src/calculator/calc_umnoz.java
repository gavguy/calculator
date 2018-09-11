package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {

    String calculate(String[] expression) {
        List<String> tmp = new ArrayList<>(List.of(expression));///1.---var tmp = , mozno i tak v 10win.


        int brOpenids = -1;
        do {
            brOpenids = -1;
            for (int i = 0; i < tmp.size(); i++) {  ///3.--- fori + tab = sozdatj
                String a = tmp.get(i);
                if (a.equals("(")) {
                    brOpenids = i;
                } else if (a.equals(")")) {
                    var inbr = tmp.subList(brOpenids + 1, i);
                    var result = calculate(inbr); ///4.---resultat na alculirovanije
                    tmp.subList(brOpenids, i + 1).clear();
                    tmp.add(brOpenids, result);
                    break;
                }
            }

        } while (brOpenids != -1);

        return calculate(tmp); ////2. ---pdgotovilis k skobockam


    }

    String calculate(List<String> expression) {    ///spisok strok
        List<String> tmp = new ArrayList<>();
        double a = Double.parseDouble(expression.get(0));
        for (int i = 1; i < expression.size(); i += 2) {
            String op = expression.get(i);
            double b = Double.parseDouble(expression.get(1 + 1));
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
                case "/":
                    a /= b;
                    break;
            }
        }

        tmp.add(String.valueOf(a));

        System.out.println(tmp);

        double result = Double.parseDouble(tmp.get(0));
        for (int i = 1; i < tmp.size(); i += 2) {
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
                    return "ERROR";
            }
        }

        return String.valueOf(result);
    }

}