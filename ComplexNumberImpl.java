package com.netcracker.edu.java.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Double.parseDouble;

public class ComplexNumberImpl implements ComplexNumber{
    public static void  main(String... args){
        testSetString();
    }

    public static void testDoubleParser(){
        String s = "1.05+1.05";
        double d = parseDouble(s);
        System.out.println(d);
    }

    public static void testMultiply(){
        ComplexNumberImpl obj1 = new ComplexNumberImpl();
        ComplexNumberImpl obj2 = new ComplexNumberImpl();
        Random rand = new Random();
        double a;
        double b;
        double c;
        double d;

        boolean error = false;
        int count = 10;
        for(int i = 0; i < count; i++){
            a = rand.nextDouble();
            b = rand.nextDouble();
            c = rand.nextDouble();
            d = rand.nextDouble();

            if (a > 0.5){
                a *= -1;
            }
            if (b > 0.5){
                b *= -1;
            }
            if (c > 0.5){
                c *= -1;
            }
            if (d > 0.5){
                d *= -1;
            }

            System.out.println("a: " + a);
            System.out.println("b: " + b);
            System.out.println("c: " + c);
            System.out.println("d: " + d);
            System.out.println();

            obj1.set(a, b);
            obj2.set(c, d);
            ComplexNumber obj3 = obj1.multiply(obj2);

            if((obj3.getRe() != a*c+b*d) || (obj3.getIm() != b*c+a*d)){
                System.out.println("TEST IS FAILED! Index:" + i);
                error = true;
            }
        }

        if (!error){
            System.out.println("Test passed successfully.");
        }
    }

    public static void testAdd() {
        ComplexNumberImpl obj1 = new ComplexNumberImpl();
        ComplexNumberImpl obj2 = new ComplexNumberImpl();
        Random rand = new Random();
        double a;
        double b;
        double c;
        double d;

        boolean error = false;
        int count = 10;
        for(int i = 0; i < count; i++){
            a = rand.nextDouble();
            b = rand.nextDouble();
            c = rand.nextDouble();
            d = rand.nextDouble();

            if (a > 0.5){
                a *= -1;
            }
            if (b > 0.5){
                b *= -1;
            }
            if (c > 0.5){
                c *= -1;
            }
            if (d > 0.5){
                d *= -1;
            }

            System.out.println("a: " + a);
            System.out.println("b: " + b);
            System.out.println("c: " + c);
            System.out.println("d: " + d);
            System.out.println();

            obj1.set(a, b);
            obj2.set(c, d);
            obj1.add(obj2);

            if((obj1.getRe() != a+c) || (obj1.getIm() != b+d)){
                System.out.println("TEST IS FAILED! Index:" + i);
                error = true;
            }
        }

        if (!error){
            System.out.println("Test passed successfully.");
        }
    }

    public static void testNegate(){
        ComplexNumberImpl a = new ComplexNumberImpl();
        a.set(0.3, -5);
        ComplexNumber b = a.negate();
        System.out.println(b.toString());
    }

    public static void testSort(){
        int sizeArray = 5;
        ComplexNumberImpl[] array = new ComplexNumberImpl[sizeArray];
        ComplexNumberImpl worker = new ComplexNumberImpl();
        Random generator = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = new ComplexNumberImpl();
            int sign = 1;
            if (i % 2 == 0){
                sign *= -1;
            }
            array[i].set(generator.nextInt(10), sign*generator.nextInt(10));
        }
        System.out.println();

        System.out.println("Source array:");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i].toString());
        }
        System.out.println();

        worker.sort(array);

        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i].toString());
        }
        System.out.println();

        boolean error = false;
        for (int i = 1; i < array.length; i++){
            if(array[i].compareTo(array[i-1]) < 0){
                System.out.println("TEST IS FAILED! Index:" + i);
                error = true;
            }
        }
        if (!error){
            System.out.println("Test passed successfully.");
        }
    }

    public static void testCompareTo(){
        ComplexNumberImpl a = new ComplexNumberImpl();
        ComplexNumberImpl b = new ComplexNumberImpl();

        a.set(1, 0);
        b.set(0, 0);
        System.out.println("Expectation: 1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(0, 1);
        b.set(0, 0);
        System.out.println("Expectation: 1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(0, 0);
        b.set(0, 1);
        System.out.println("Expectation: -1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(0, 0);
        b.set(1, 0);
        System.out.println("Expectation: -1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(0, 0);
        b.set(1, 1);
        System.out.println("Expectation: -1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(1, 1);
        b.set(0, 0);
        System.out.println("Expectation: 1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(0, 0);
        b.set(0, 0);
        System.out.println("Expectation: 0");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(-2, 2);
        b.set(2, -2);
        System.out.println("Expectation: 0");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(2, -2);
        b.set(-2, 2);
        System.out.println("Expectation: 0");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(2.35, -2.35);
        b.set(-2.35, 2.35);
        System.out.println("Expectation: 0");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(1, 1);
        b.set(1, 1);
        System.out.println("Expectation: 0");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(0, 0);
        b.set(-1, 1);
        System.out.println("Expectation: -1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();

        a.set(1, -1);
        b.set(0, 0);
        System.out.println("Expectation: 1");
        System.out.println("Reality: " + a.compareTo(b));
        System.out.println();
    }

    public static void testEquals(){
        ComplexNumberImpl a = new ComplexNumberImpl();
        ComplexNumberImpl b = new ComplexNumberImpl();

        a.set(0, -1);
        b.set(0, 2);
        System.out.println("Expectation: false");
        System.out.println("Reality: " + a.equals(b));
        System.out.println();

        a.set(0, -1);
        b.set(0, -1);
        System.out.println("Expectation: true");
        System.out.println("Reality: " + a.equals(b));
        System.out.println();

        ComplexNumber c = new ComplexNumberImpl();
        ComplexNumberImpl d = new ComplexNumberImpl();

        c.set(0, -1);
        d.set(0, 2);
        System.out.println("Expectation: false");
        System.out.println("Reality: " + c.equals(d));
        System.out.println();

        c.set(0, 2);
        d.set(0, 2);
        System.out.println("Expectation: true");
        System.out.println("Reality: " + c.equals(d));
        System.out.println();

        ComplexNumberImpl e = new ComplexNumberImpl();
        ComplexNumberImpl f = new ComplexNumberImpl();

        e.set(0, -1);
        f.set(0, 2);
        System.out.println("Expectation: false");
        System.out.println("Reality: " + e.equals(f));
        System.out.println();

        e.set(0, 2);
        f.set(0, 2);
        System.out.println("Expectation: true");
        System.out.println("Reality: " + e.equals(f));
        System.out.println();

        ComplexNumberImpl g = new ComplexNumberImpl();
        ArrayList h = new ArrayList();
        System.out.println("Expectation: false");
        System.out.println("Reality: " + g.equals(h));
        System.out.println();

        ComplexNumberImpl j = new ComplexNumberImpl();
        ComplexNumber k = j;
        System.out.println("Expectation: true");
        System.out.println("Reality: " + j.equals(k));
        System.out.println();
    }

    public static void testToString(){
        ComplexNumberImpl obj = new ComplexNumberImpl();
        double[][] arr = {{-5, 2}, {0, 2}, {1, 1}, {4, -2}, {0, 1}, {0, -3}, {3, 0}, {0, 0}, {0, -1}};
        for (int i = 0; i < arr.length; i++){
            obj.set(arr[i][0], arr[i][1]);
            System.out.println("Real part: " + obj.getRe());
            System.out.println("Imaginary part: " + obj.getIm());
            System.out.println("To string: " + obj.toString());
            System.out.println();

        }

    }

    public static void testCopy(){
        ComplexNumber object = new ComplexNumberImpl();
        object.set(1, 5);
        ComplexNumber objectcopy = object.copy();

        System.out.println("Real part: " + objectcopy.getRe());
        System.out.println("Imaginary part: " + objectcopy.getIm());
        System.out.println();

        System.out.println("Expectation: true");
        System.out.println("Reality: " + object.copy().equals(object));
        System.out.println();

        System.out.println("Expectation: true");
        System.out.println("Reality: " + (object.copy() != object));
    }

    public static void testSetString(){
        String[] b = {"-5+2i", "+0+2i", "1+i", "+4-i", "i", "-3i", "3", "-0", "-0-i", "+0+i", "-0-0i", "+0+0i", "1.05+1.05"};
        ComplexNumberImpl obj = new ComplexNumberImpl();
        for (String s : b){
            obj.set(s);
            System.out.println("Real part: " + obj.getRe());
            System.out.println("Imaginary part: " + obj.getIm());
            System.out.println();
        }
    }

    private double re;
    private double im;

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        if (im == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        char[] array = value.toCharArray();
        int lastSignPos = -1;
        int iPosition = -1;

        //i
        if ((array.length == 1) && (array[0] == 'i')){
            re = 0;
            im = 1;
            return;
        }

        for(int i = 0; i < array.length; i++){
            if (((array[i] == '+') || (array[i] == '-'))){
                lastSignPos = i;
            }
            if (array[i] == 'i'){
                iPosition = i;
            }
        }

        //-i, +4-i, 1+i
        if(iPosition == (lastSignPos+1)){
            if (lastSignPos == 0){
                re = 0;
                im = -1;
                return;
            } else {
                re = parseDouble(value.substring(0, lastSignPos));
                if (re == -0.0){
                }
                if (array[lastSignPos] == '-'){
                    re = 0;
                    im = -1;
                    return;
                }else if (array[lastSignPos] == '+') {
                    im = 1;
                    return;
                } else {
                    System.out.println("Invalid expression!");
                    return;
                }
            }
        }

        //"3"
        if (((lastSignPos == -1) || (lastSignPos == 0)) && (iPosition == -1) && (array.length > 0)){
            re = parseDouble(value);
            if (re == -0.0){
                re = 0;
            }
            im = 0;
            return;
        }

        //"-3i"
        if (((lastSignPos == 0) || (lastSignPos == -1)) && (iPosition == (array.length-1))){
            re = 0;
            if (lastSignPos == 0) {
                re = 0;
                im = parseDouble(value.substring(lastSignPos, value.length() - 1));
                if (im == -0.0){
                    im = 0;
                }
                return;
            } else {
                re = 0;
                im = parseDouble(value.substring(0, value.length() - 1));
                if (im == -0.0){
                    im = 0;
                }
                return;
            }
        }

        //duct tape
        if ((lastSignPos > 0) && (iPosition == -1)){
            double temp = parseDouble(value);
        }

        //"-5+2i"
        re = parseDouble(value.substring(0, lastSignPos));
        im = parseDouble(value.substring(lastSignPos, value.length() - 1));

        if (re == -0.0){
            re = 0;
        }
        if (im == -0.0){
            im = 0;
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber object = new ComplexNumberImpl();
        object.set(re, im);
        return object;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        ComplexNumber object = new ComplexNumberImpl();
        object.set(re, im);
        return object;
    }

    @Override
    public String toString(){
        if ((re == 0) && (im == 0)){
            return "0.0";
        }
        StringBuilder builder = new StringBuilder();
        if (re != 0) {
            builder.append(re);
            if (im > 0){
                builder.append("+");
            }
        }
        if (im != 0) {
            builder.append(im + "i");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (other instanceof ComplexNumber)
            return ((ComplexNumber) other).getRe() == re && ((ComplexNumber) other).getIm() == im;
        return false;
    }

    @Override
    public int compareTo(ComplexNumber other) {
        if ((re*re + im*im) == (other.getRe()*other.getRe() + other.getIm()*other.getIm())) {
            return 0;
        }
        if ((re*re + im*im) < (other.getRe()*other.getRe() + other.getIm()*other.getIm())) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        re *= -1;
        im *= -1;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double buf = re*arg2.getRe() + im*arg2.getIm();
        im = im*arg2.getRe() + re*arg2.getIm();
        re = buf;
        return this;
    }
}
