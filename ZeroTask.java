package com.netcracker.edu.java.tasks;

/**
 * GOAL
 * This trivial pseudo-task checks your ability to write solutions of Skill Bench tasks and check them here.
 * If you know Java to some extent, please do not solve this pseudo-task (to begin with Skill Bench, solve another simple task).
 *
 * TASK
 * Create a class named ZeroTaskImpl in your IDE (in the package com.netcracker.edu.java.tasks) and implement this interface in it.
 * The common requirement for any task (to check it online) is to declare your class as follows:
 * public class ZeroTaskImpl implements ZeroTask {  }
 *
 * When no compilation errors exist in ZeroTaskImpl you may copy it to the Input tab and press Check button.
 */
public interface ZeroTask {
    //private int integerValue = 0;
    /**
     * Sets the value of a field of the class.
     */
    //If you define the field integerValue like commented above, then implementation of this method will be as follows:
    //	integerValue = value;
    public void setIntegerValue(int value);
    /**
     * Returns the value of the field which was set by the setIntegerValue method.
     * The initial value of the field (before calling setIntegerValue method) must be 0.
     * Note: in Java, the value of int type may be casted _implicitly_ to double type.
     */
    //If you define the field integerValue like commented above, then implementation of this method will be as follows:
    //	return integerValue;
    public double getDoubleValue();
}

