package basic;

/**
 * Exceptions
 */
public class Exceptions {
    public static void main(String[] args) {
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