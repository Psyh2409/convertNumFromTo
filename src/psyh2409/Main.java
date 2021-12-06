package psyh2409;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        convertFromTo(179382720, 16);
        convertFromToDec("Ab129C0", 16);
    }

    public static void convertFromTo(int number, int radix) {
        StringBuilder answer = new StringBuilder();
        while (number > 0) {
            int remainder = number % radix;
            if (remainder < 10) {
                answer.append(remainder);
            } else {
                answer.append((char) (((int) 'A' + remainder) - 10));
            }
            number /= radix;
        }
        System.out.println(answer.reverse());
    }


    public static void convertFromToDec(String number, int radix) {
        int power = 1;
        int answer = 0;
        number = number.toUpperCase(Locale.ROOT);
        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) < 'A') {
                answer += Integer.parseInt(String.valueOf(number.charAt(i))) * power;
            } else {
                answer += (number.charAt(i) - 'A' + 10) * power;
            }
            power *= radix;
        }
        System.out.println(answer);
    }
}