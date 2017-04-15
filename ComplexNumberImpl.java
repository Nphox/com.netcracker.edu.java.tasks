package com.netcracker.edu.java.tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Character.isDigit;
import static java.lang.Double.doubleToLongBits;
import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;
import static java.lang.System.in;
import static java.lang.System.setOut;
import static jdk.nashorn.internal.objects.NativeString.substring;

public class ComplexNumberImpl implements ComplexNumber{
    public static void  main(String... args){
        testEquals();
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
        String[] b = {"-5+2i", "+0+2i", "1+i", "+4-2i", "i", "-3i", "3", "-0", "-0-i", "+0+i", "-0-0i", "+0+0i"};
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
        //<code>x.copy().equals(x)</code> but <code>x.copy()!=x</code>.
        ComplexNumber object = new ComplexNumberImpl();
        object.set(1, 5);
        ComplexNumber objectcopy = object.copy();
        System.out.println("Real part: " + objectcopy.getRe());
        System.out.println("Imaginary part: " + objectcopy.getIm());
    }

    public static void testSetString(){
        //Correct examples: "-5+2i", "1+i", "+4-i", "i", "-3i", "3".
        String[] b = {"-5+2i", "+0+2i", "1+i", "+4-i", "i", "-3i", "3", "-0", "-0-i", "+0+i", "-0-0i", "+0+0i"};
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
                re = parseDouble(substring(value, 0, lastSignPos));
                if (re == -0.0){
                    re = 0;
                }
                if (array[lastSignPos] == '-'){
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
                im = parseDouble(substring(value, lastSignPos, value.length() - 1));
                if (im == -0.0){
                    im = 0;
                }
                return;
            } else {
                re = 0;
                im = parseDouble(substring(value, 0, value.length() - 1));
                if (im == -0.0){
                    im = 0;
                }
                return;
            }
        }

        //"-5+2i"
        re = parseDouble(substring(value, 0, lastSignPos));
        im = parseDouble(substring(value, lastSignPos, value.length() - 1));

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
            if (!(im == -1 || im == 1)) {
                builder.append(im);
            }
            builder.append("i");
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
        return 0;
    }

    @Override
    public void sort(ComplexNumber[] array) {

    }

    @Override
    public ComplexNumber negate() {
        return null;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        return null;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        return null;
    }
}
