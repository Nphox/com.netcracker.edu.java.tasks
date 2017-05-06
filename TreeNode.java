package com.netcracker.edu.java.tasks;

import java.util.Iterator;

/**
 * GOALS<ul>
 * <li>To practice with typical operations with tree-like data structure.</li>
 * <li>To be able to choose the convenient Collection for storing data.</li>
 * <li>To get familiar with Iterator and Chain of Responsibility design patterns.</li>
 * </ul>
 * <p/>
 * TASK<br/>
 * Implement a class for an object that can be used as a node in some tree (e.g. in some UI component).<br/>
 * The Collection of children should be initialized on demand only, i.e. on adding a child
 * ("lazy initialization" pattern).<br/>
 * <p/>
 * The example of a similar data structure: <a href="http://www.primefaces.org/docs/api/5.1/org/primefaces/model/DefaultTreeNode.html">
 *  DefaultTreeNode in JSF Primefaces</a><br/>
 *
 * @author Georgii Kolpakov
 * @author Alexey Evdokimov
 */
public interface TreeNode {

    /**
     * Returns the parent <code>TreeNode</code>.
     */
    TreeNode getParent();
    /**
     * Sets the parent <code>TreeNode</code>.<br/>
     * Is typically called in {@link #addChild(TreeNode)} and {@link #removeChild(TreeNode)} methods
     *  of the parent <code>TreeNode</code> itself.
     */
    void setParent(TreeNode parent);
    /**
     * Returns the top of the tree that contains this <code>TreeNode</code>.
     * @return root node or null if the parent of this node is null (i.e. the returned node != this).
     */
    TreeNode getRoot();

    /**
     * Returns false if this <code>TreeNode</code> has non-zero number of children.
     * @return true if the node is a leaf (i.e. does not have child nodes)
     */
    boolean isLeaf();
    /**
     * Returns the number of children which this <code>TreeNode</code> has.
     */
    int getChildCount();
    /**
     * Returns children <code>TreeNode</code>'s as {@link Iterator}.
     */
    Iterator<TreeNode> getChildrenIterator();
    /**
     * Adds the given child to this <code>TreeNode</code> and sets this as the parent to it.
     */
    void addChild(TreeNode child);
    /**
     * Removes the given child from this <code>TreeNode</code> and (if succeeded)
     *  sets null as the parent to it (in order to leave the tree in the consistent state).
     * @return true if succeeded, false if the child was not found
     */
    boolean removeChild(TreeNode child);

    /**
     * Returns the "expanded" state of this <code>TreeNode</code>.<br/>
     * By default (unless {@link #setExpanded(boolean)} is called)
     *  "expanded" is false (i.e. the node is "collapsed").
     */
    boolean isExpanded();
    /**
     * Sets the "expanded" state to this <code>TreeNode</code> and to all its children, recursively
     * @param expanded true - to expand this tree branch, false - to collapse this tree branch.
     */
    void setExpanded(boolean expanded);

    /**
     * Returns the user object stored in this <code>TreeNode</code>
     *  or <code>null</code> if {@link #setData(Object)} was not called.
     */
    Object getData();
    /**
     * Sets the user data to store in this <code>TreeNode</code>.
     */
    void setData(Object data);
    /**
     * Returns the string representation of the path from root to this <code>TreeNode</code>.<br/>
     * Path elements are separated by "->".<br/>
     * Each path element is either getData().toString() or "empty" if getData()==null.<br/>
     * For example: "rootNode0->node1->node13->empty" ("rootNode0" is a result of getRoot().getData().toString() in this example).
     */
    String getTreePath();
    /**
     * Finds the (first) node with the given data among the parents' sequence of this <code>TreeNode</code>.
     * By convention, the parents' sequence includes this node itself (i.e. the following may be true: obj.findParent(*) == obj).<br/>
     * Data objects should be compared by equals() method (but if the given data is null then the parent with null data should be returned).
     * @param data the data to find; may be <code>null</code>
     * @return the node found or <code>null</code> if no matching data was found.
     */
    TreeNode findParent(Object data);
    /**
     * Finds the (first) node with the given data among the children of this <code>TreeNode</code>.<br/>
     * Searches it recursively (if some child doesn't have the given data, the children of this child are searched, and so on).<br/>
     * Data objects should be compared by equals() method (but if the given data is null then the child with null data should be returned).
     * @param data the data to find; may be <code>null</code>
     * @return the node found or <code>null</code> if no matching data was found.
     */
    TreeNode findChild(Object data);
}

