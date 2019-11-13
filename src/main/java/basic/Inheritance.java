package basic;

import tools.AccessClass;
import tools.ToolChild;

/**
 * Inheritance
 */
public class Inheritance {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.a);
        // System.out.println(child.b);
        System.out.println(child.c);
        System.out.println(child.d);

        AccessClass class1 = new AccessClass();
        System.out.println(class1.a);
        // System.out.println(class1.c);

        ToolChild child2 = new ToolChild();
        System.out.println(child2.a);
        // System.out.println(child2.b);
        System.out.println(child2.c);
        // System.out.println(child2.d);
    }
}

class Child extends PublicClass {
    public Child(){
        a = 1;
        // b = 2;
        c = 3;
        d = 4;
    }
}