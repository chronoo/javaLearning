package basic;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Boolean
 */
public class Stepik {
    public static void main(final String[] args) {
        testEqualsAndHash();
    }

     // пункт 3.4, 9 шаг
     public static void testEqualsAndHash() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);

        System.out.println(a.equals(b));
        System.out.println(a.hashCode() + ":" + b.hashCode());
    }

    // пункт 2.4, 9 шаг
    public static int[] mergeArrays(final int[] a1, final int[] a2) {
        final int[] result = new int[a1.length + a2.length];
        int next;

        for (int i = 0, i1 = 0, i2 = 0; i < a1.length + a2.length; i++) {
            if (i1 == a1.length)
                next = a2[i2++];
            else if (i2 == a2.length)
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
    public static BigInteger factorial(final int value) {
        BigInteger result = BigInteger.valueOf(value);
        for (int i = value - 1; i > 1; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // пункт 2.3, 10 шаг
    public static boolean isPalindrome1(final String text) {
        final String result = text.replaceAll("[^a-zA-Z0-9]", "");
        final StringBuilder sb = new StringBuilder(result);
        final String reverse = sb.reverse().toString();
        return result.equalsIgnoreCase(reverse);
    }

    // пункт 2.3, 10 шаг
    public static boolean isPalindrome(final String text) {
        final String upperCase = text.toUpperCase();
        final Pattern pattern = Pattern.compile("[A-Z0-9]");
        final Matcher matcher = pattern.matcher(upperCase);
        final StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(upperCase.substring(matcher.start(), matcher.end()));
        }
        final String origin = sb.toString();
        final String reverse = sb.reverse().toString();
        return origin.equals(reverse);
    }

    // пункт 2.3, 8 шаг
    private static void stringConcat() {
        final String string1 = "A" + ('\t' + '\u0003');
        final String string2 = "A" + 12;
        final String string3 = 'A' + '1' + "2";
        final String string4 = 'A' + "12";
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);
    }

    // пункт 2.2, 10 шаг
    public static boolean isPowerOfTwo(final int value) {
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
    public static char charExpression(final int a) {
        return (char) ('\\' + a);
    }

    // пункт 2.1, 13 шаг
    public static int flipBit(int value, final int bitIndex) {
        return value ^= (1 << bitIndex - 1);
    }

    // пункт 2.1, 11 шаг
    public static boolean doubleExpression(final double a, final double b, final double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }

    // пункт 2.1, 7 шаг
    public static int leapYearCount(final int year) {
        return year / 4 - year / 100 + year / 400;
    }

    // пункт 2.1, 5 шаг
    // это совсем не то, чего хотел автор, но СДНФ это уже перебор
    public static boolean booleanExpression(final boolean a, final boolean b, final boolean c, final boolean d) {
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
        final boolean[] a = { false, true };

        for (final boolean item1 : a) {
            for (final boolean item2 : a) {
                System.out.println(item1 + ":" + item2 + " = " + (item1 ^ item2));
            }
        }
    }
}

class Parent {
    final int a = 0;
    static final int b = 1;
    protected Object method(Object value) {
        return new Object();
    }

    private Object privateMethod(Object value) {
        return new Object();
    }
}

class Children extends Parent {
    public BigInteger method(Object value) {
        return (BigInteger) super.method(value);
    }
}