package cube;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cube {

    public static void main(String[] args) {
        calculate("2D10+10");
    }

    static int calculate(String str) {
        /*
        Zostały tu użyte wyrażenia regularne które będą omawiane na 3 module
            \\d oznacza cyfrę,
            ? coś co poprzedza ten znak występuje lub nie
            + przynajmniej jedno wystapienie tego co poprzedza znak plusa
            [] wartość ze zbioru podanego w nawiasach
            () grupują pewne części które można potem pobrać w kodzie programu
        */
        Pattern pattern = Pattern.compile("(\\d)?D(\\d+)([\\+\\-]\\d+)?");
        Matcher matcher = pattern.matcher(str);
        int val = 0;
        int multi = 1;
        int sides;
        int modifier = 0;
        if (matcher.find()) {
            multi = 1;
            modifier = 0;
            if (matcher.group(1) != null) {
                multi = Integer.parseInt(matcher.group(1));
            }
            sides = Integer.parseInt(matcher.group(2));
            if (matcher.group(3) != null) {
                modifier = Integer.parseInt(matcher.group(3));
            }
            System.out.println(multi + "D" + sides + modifier);
            for (int i = 0; i < multi; i++) {
                val += new Random().nextInt(sides) + 1;
            }

            val += modifier;

        }
        return val;
    }
}
