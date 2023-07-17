import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class forTest {



    public static void swap(Integer a, Integer b)
    {
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println("in func");
        System.out.println(a + " " + b);
    }

    public static void swap(Integer[] a, Integer[] b)
    {
        Integer temp = a[0];
        a[0] = b[0];
        b[0] = temp;
        System.out.println("in func");
        System.out.println(a[0] + " " + b[0]);
    }




    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;

        //System.out.println("before func");
        //System.out.println(a + " " + b);
        //swap(a, b);
        Integer[] a1 = {a};
        Integer[] b1 = {b};
        System.out.println("before func");
        System.out.println(a1[0] + " " + b1[0]);
        swap(a1, b1);
        System.out.println("after func");
        System.out.println(a1[0] + " " + b1[0]);
        System.out.println("original a and b");
        System.out.println(a + " " + b);
        int x = 5;
        x = x + 1;
        System.out.println(x);

        int y = 10;
        System.out.println(++y + y++);
        B bibi = new B(5);

    }
}


