package basic;

import java.io.Closeable;

/**
 * Exceptions
 */
public class Exceptions {
    public static void main(String[] args) {
        Integer numb = getNumber();
        System.out.println(numb);
    }

    public static Integer getNumber() {
        try {
            if (true) {
                throw new MyExp();
            }
            return 42;
        } catch (NullPointerException e) {
            System.out.println(e);
            return 44;
        // } catch (Exception e) {
        //     System.out.println(e);
        //     return 45;
        }finally{
            System.out.println("finally");
            return 43;
        }
        // return 44;
    }

    private static void throwCustomException() {
        try {
            try {
                throw new MyExp("sdf");
            } catch (MyExp e) {
                System.out.println(e);
                throw new Exception();
            } catch (Exception e) {
                System.out.println(e);
            }
            throw new MyExp("unchecked");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void useResource() {
        try (MyResource res = new MyResource()) {
            res.justDo();
        } catch (Exception err) {
            System.out.println(err);
        } finally {
            System.out.println("finally-block");
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

class MyExp extends RuntimeException {
    public MyExp(){
        super();
    }
    public MyExp(String msg) {
        super(msg);
    }
}

class MyResource implements Closeable {
    public MyResource() {
    }
    
    public void justDo() {
        System.out.println("just do");
        System.out.println("do something with resource");
        throw new RuntimeException("main");
    }
    @Override
    public void close() {
        System.out.println("close");
        throw new RuntimeException("resource");
    }
}

