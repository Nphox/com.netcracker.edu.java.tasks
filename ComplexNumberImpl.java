package com.netcracker.edu.java.tasks;

import java.lang.reflect.Array;

import static java.lang.Character.isDigit;
import static java.lang.Double.doubleToLongBits;
import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;
import static jdk.nashorn.internal.objects.NativeString.substring;

public class ComplexNumberImpl implements ComplexNumber{
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
        double temp;
        int signRe = 1;
        int signIm = 1;
        int i = 0;
        char[] array = value.toCharArray();
        //Correct examples: "-5+2i", 1+i", "+4-i", "i", "-3i", "3".
        //Correct examples: "-5.71+2i", 1+i", "+4-i", "i", "-3i", "3".

        if (array[i] == '-'){
            signRe = -1;
            i++;
        }

        else if(array[i] == '+'){
            i++;
        }

        else if(array[i] == 'i'){

            if(array.length == 1){
                re = 0;
                im = 1;
            }

            else{
                System.out.println("Invalid expression!");
                return;
            }
        }

        else if(isDigit(array[i])) {

            int beginIndex = i;
            boolean pointMet = false;

            while ((isDigit(array[i])) || (array[i] == '.') && (i < array.length)) {

                if (array[i] == '.') {

                    if (pointMet == true) {
                        System.out.println("Invalid expression!");
                        return;
                    }

                    else {
                        pointMet = true;
                    }

                    i++;
                }

                i++;
            }

            int endIndex = i - 1;
            temp = signRe * parseDouble(substring(beginIndex, endIndex));

            if (array.length == i) {
                re = temp;
                return;
            }

            else if ((array[i] == 'i') && (array.length == (i+1))) {
                re = 0;
                im = temp;

            }

            if (array[i] == '-') {
                signIm = -1;
            }

            if (array[i] == '+') {

                i++;

                if(isDigit(array[i])) {

                    beginIndex = i;
                    pointMet = false;

                    while ((isDigit(array[i])) || (array[i] == '.') && (i < array.length)) {

                        if (array[i] == '.') {

                            if (pointMet == true) {
                                System.out.println("Invalid expression!");
                                return;
                            }

                            else {
                                pointMet = true;
                            }

                            i++;
                        }

                        i++;
                    }

                    endIndex = i - 1;
                    temp = signIm * parseDouble(substring(beginIndex, endIndex));

                    if (array.length == i) {
                        System.out.println("Invalid expression!");
                        return;
                    }

                    else if ((array[i] == 'i') && (array.length == ++i)){
                        re = temp;
                        im = temp;
                        return;
                    }

                    else {
                        System.out.println("Invalid expression!");
                        return;
                    }

                }

            }





            } else {
                System.out.println("Invalid expression!");
                return;
            }
        }
    }

    @Override
    public ComplexNumber copy() {
        return null;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return null;
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
