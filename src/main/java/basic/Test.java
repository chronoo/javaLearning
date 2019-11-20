package basic;

/**
 * Test
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] trace = e.getStackTrace();
            if (trace.length < 3)
                return null;
            else {
                StackTraceElement element = trace[2];
                return element.getClassName() + "#" + element.getMethodName();
            }
        }
    }
}