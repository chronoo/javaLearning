package basic;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Boolean
 */
public class Stepik {
    public static void main(String[] args) {
        System.out.println(mergeArrays(new int[] {1,2,3}, new int[]{3,4,5}));
    }

      // пункт 2.4, 9 шаг
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int next;

        for (int i = 0, i1 = 0, i2 = 0; i < a1.length + a2.length; i++) {
            if (i1 == a1.length)
                next = a2[i2++];
            else if(i2 == a2.length)
                next = a1[i1++];
            else {
                if (a1[i1] <= a2[i2]) {
                    next = a1[i1++];
                } else {
                    next = a2[i2++];
                }
            }

            result[i] = next;
        }
        return result;
    }

     // пункт 2.4, 8 шаг
     public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(value);
        for (int i = value - 1; i > 1; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    // пункт 2.3, 10 шаг
    public static boolean isPalindrome1(String text) {
        String result = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(result);
        String reverse = sb.reverse().toString();
        return result.equalsIgnoreCase(reverse);
    }

    // пункт 2.3, 10 шаг
    public static boolean isPalindrome(String text) {
        String upperCase = text.toUpperCase();
        Pattern pattern = Pattern.compile("[A-Z0-9]");
        Matcher matcher = pattern.matcher(upperCase);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(upperCase.substring(matcher.start(), matcher.end()));
        }
        String origin = sb.toString();
        String reverse = sb.reverse().toString();
        return origin.equals(reverse);
    }

    // пункт 2.3, 8 шаг
    private static void stringConcat() {
        String string1 = "A" + ('\t' + '\u0003');
        String string2 = "A" + 12;
        String string3 = 'A' + '1' + "2";
        String string4 = 'A' + "12";
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);
    }

    // пункт 2.2, 10 шаг
    public static boolean isPowerOfTwo(int value) {
        return java.lang.Integer.bitCount(Math.abs(value)) == 1;
    }

    // пункт 2.2, 9 шаг
    public static void typeTransfer() {
        // int a = 4;
        // String b = "a";
        // a = b; // String->int
        // boolean c = a; // int->boolean
        // long d = 1;
        // float e = d; // long->float +
        // d = a; // int->long +
        // d = e; // float->long
        // byte f = 4;
        // char g = f; // byte->char
        // a = g; // chat->int +
        // Character h = g;// char->Character +
    }

    // пункт 2.2, 3 шаг
    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    // пункт 2.1, 13 шаг
    public static int flipBit(int value, int bitIndex) {
        return value ^= (1 << bitIndex - 1);
    }

    // пункт 2.1, 11 шаг
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }

    // пункт 2.1, 7 шаг
    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    // пункт 2.1, 5 шаг
    // это совсем не то, чего хотел автор, но СДНФ это уже перебор
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        int trueCount = 0;

        if (a)
            trueCount++;
        if (b)
            trueCount++;
        if (c)
            trueCount++;
        if (d)
            trueCount++;

        return trueCount == 2;
    }

    public static void opreatorTest() {
        boolean[] a = { false, true };

        for (boolean item1 : a) {
            for (boolean item2 : a) {
                System.out.println(item1 + ":" + item2 + " = " + (item1 ^ item2));
            }
        }
    }
}