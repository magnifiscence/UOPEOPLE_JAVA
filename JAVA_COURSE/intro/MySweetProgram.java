package JAVA_COURSE.intro;

import java.util.Scanner;

public class MySweetProgram {
    public static void main(String[] args) {
        System.out.println("what is your name");

        // type identifier = new type();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();

        System.out.println("hello " + name);

        String string = new String("This is a string");
        // String easier = "another way of defining strings";

        int x = 5; // primitive
        Integer y = 5; // object (5 is autoboxed)
        // primitive data types

        // boolean isPizzaDelicious = true;
        // byte b = 127; /1010101;
        // char c = 'z';
        // short s = -32768;
        // long l = 5555900004L;
        // long l = 50L;
        // float f = 20.5f;
        // double d = 20.5;

        System.out.println(x);
        System.out.println(y);

        System.out.println(string + " :) ");
    }
}

// the difference between float and double is a float is 32bit and a double is
// 64bit, and its advisable to always use a double
// we can store a float in a double e.g double dd = 20.5f; but you cant store a
// float in a double e.g float ff = 20.5;
// static means we dont have to create an instance of the class
// public means any class can access its content and private does the opposite.
// final int x = 10; makes it a constant
// primitive types e.g float, int, double, char, string, etc
// objects - instance of a class (class is the data type)
// statically typed - variables are given data types up front (before
// compilation)
// dynamically typed - variables donot have types

// variable - stores some value
// expression - evsluates to a value
// operator - work on operands to produce a value
// operand - the thing(s) the operator works on

// comment
// class - contains everything - has members
// methods - do something
// arguments - what you pass to a method (part of the calling)
// parameter - variables to store arguments (part of definition)
// statements - Telling the computer something