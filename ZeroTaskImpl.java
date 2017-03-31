package com.netcracker.edu.java.tasks;

public class ZeroTaskImpl implements ZeroTask{
    public static void main(String... args){
        ZeroTaskImpl object = new ZeroTaskImpl();
        //object.setIntegerValue(12);
        System.out.println(object.getDoubleValue());
    }

    int integerValue = 0;

    @Override
    public void setIntegerValue(int value) {
        integerValue = value;
    }

    @Override
    public double getDoubleValue() {
        return integerValue;
    }
}
