package psyh2409;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        convertFromTo(67, 2);
        convertFromTo(92, 2);
        convertFromTo(1267, 2);
        convertFromTo(873, 2);
        convertFromTo(1034, 2);
        convertFromTo(789, 2);

        convertFromToDec("101100010", 2);
        convertFromToDec("1010111", 2);
        System.out.println(0b101100010 - 0b1010111);

        convertFromToDec("27241", 8);
        convertFromTo(1739, 8);
        convertFromTo(28036, 16);
        convertFromTo(0x2f5a, 10);

    }

    public static void convertFromTo(int number, int radix) {
        StringBuilder answer = new StringBuilder();
        while (number > 0) {
            int remainder = number % radix;
            if (remainder < 10) {
                answer.append(remainder);
            } else {
                answer.append((char) ('A' + remainder - 10));
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
                answer += Integer.parseInt(number.substring(i, i+1)) * power;
            } else {
                answer += (number.charAt(i) - 'A' + 10) * power;
            }
            power *= radix;
        }
        System.out.println(answer);
    }
}
/*
1)
11/2 = 5 + 11%2    1
5/2 = 2 + 5%2     1
2/2 = 1 + 2%2    0
1/2 = 0 + 1%2   1
                1011
67/2 = 33 + 67%2        1
33/2 = 16 + 33%2       1
16/2 = 8 + 16%2       0
8/2 = 4 + 8%2        0
4/2 = 2 + 4%2       0
2/2 = 1 + 2%2      0
1/2 = 0 + 1%2     1
                  1000011
92/2 = 46 +                  0
       46/2 = 23 +          0
              23/2 = 11 +  1
                       1011100
1267/2 = 633 +           1
633/2 = 316 +           1
316/2 = 158 +          0
158/2 = 79 +          0
79/2 = 39 +          1
39/2 = 19 +         1
19/2 = 9 +         1
9/2 = 4 +         1
4/2 = 2 +        0
2/2 = 1 +       0
1/2 = 0 +      1
               10011110011
873/2 = 436 +      1
436/2 = 218 +     0
218/2 = 109 +    0
109/2 = 54 +    1
54/2 = 27 +    0
27/2 = 13 +   1
13/2 = 6 +   1
6/2 = 3 +   0
3/2 = 1 +  1
1/2 = 0 + 1
          1101101001
1034/2 = 517 +        0
517/2 = 258 +        1
258/2 = 129 +       0
129/2 = 64 +       1
            10000001010
789/2 = 394 +       1
394/2 = 197 +      0
197/2 = 98 +      1
98/2 = 49 +      0
49/2 = 24 +     1
24/2 = 12 +    0
12/2 = 6 +    0
6/2 = 3 +    0
3/2 = 1 +   1
1/2 = 0 +  1
           1100010101
2)
10011 = 1*2^0 + 1*2^1 + 0*2^2 + 0*2^3 + 1*2^4 = 1+2+0+0+16 = 19
1111001 = 1+0+0+8+16+32+64 = 121
10110110 = 0+2+4+0+16+32+0+128 = 182
111000 = 0+0+0+8+16+32 = 56
1001 = 1+0+0+8 = 9
11001101 = 1+0+4+8+0+0+64+128 = 205
3)
354/2 = 177 +      0
177/2 = 88 +      1
88/2 = 44 +      0
44/2 = 22 +     0
22/2 = 11 +    0
           101100010
87/2 = 43 +        1
43/2 = 21 +       1
21/2 = 10 +      1
10/2 = 5 +      0
5/2 = 2 +      1
2/2 = 1 +     0
1/2 = 0 +    1
             1010111
_ 101100010
    1010111
 -----------
  100001011 = 1+2+0+8+0+0+0+0+256 = 267

4)
027241 = 1*8^0+4*8^1+2*8^2+7*8^3+2*8^4 = 11937
1739/8 = 217 + 3
217/8 = 27 +  1
27/8 = 3 +   3
3/8 = 0 +   3
           03313
28036/16 = 1752 +    4
1752/16 = 109 +     8
109/16 = 6 +  13 = D
6/16 = 0 +        6
                0x6D84
0x2F5A = 0xA*16^0+5*16^1+0xF*16^2+2*16^3 = 12122
*/