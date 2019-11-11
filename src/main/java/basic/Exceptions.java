package basic;

import java.io.Closeable;
import java.io.IOException;

/**
 * Exceptions
 */
public class Exceptions {
    public static void main(String[] args) {
        try (MyResource res = new MyResource()) {
            res.justDo();
            System.out.println("do something with resource");
        } catch (Exception err) {
            System.out.println("error");
        }
    }

    public static class MyResource implements Closeable {

        public MyResource() {
        }
        
        public void justDo() throws Exception {
            System.out.println("just do");
            throw new Exception();
        }
        @Override
        public void close() {
            System.out.println("close");
        }
    }

    private static void doSomething() {
        try {
            // throw new NullPointerException();
            throw new Exception();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            try {
                throw new Exception("s");
            } catch (Exception e1) {
                System.out.println("Exception from NPE");
            }
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            try {
                System.out.println("finally");
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Exception from finally");
            }
            System.out.println("finally finish");
        }
        System.out.println("main finish");
    }
}