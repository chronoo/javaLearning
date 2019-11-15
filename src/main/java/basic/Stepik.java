package basic;

/**
 * Boolean
 */
public class Stepik {
    public static void main(String[] args) {
        for (int i = -4; i < 100; i++) {
            System.out.println(i + ":" + isPowerOfTwo(i));
        }
    }

      // пункт 2.3, 10 шаг
      public static boolean isPowerOfTwo(int value) {
        return java.lang.Integer.bitCount(Math.abs(value)) == 1;
    }

     // пункт 2.3, 9 шаг
     public static void typeTransfer() {
        // int a = 4;
        // String b = "a";
        // a = b;          // String->int
        // boolean c = a;  // int->boolean
        // long d = 1;   
        // float e = d;    // long->float +
        // d = a;          // int->long +
        // d = e;          // float->long
        // byte f = 4;
        // char g = f;     // byte->char
        // a = g;          // chat->int +
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
        return year/4 - year/100 + year/400;
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