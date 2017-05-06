package com.netcracker.edu.java.tasks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TreeNodeImpl implements TreeNode {
    private Object data;
    private TreeNode parent;
    private Set<TreeNode> childSet = new HashSet<TreeNode>();
    private boolean expanded = false;

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if (parent == null){
            return null;
        }
        TreeNode tempParent = parent;
        while(tempParent.getParent() != null){
            tempParent = tempParent.getParent();
        }
        return tempParent;
    }

    @Override
    public boolean isLeaf() {
        return childSet.isEmpty();
    }

    @Override
    public int getChildCount() {
        return childSet.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        Iterator iterator = childSet.iterator();
        return iterator;
    }

    @Override
    public void addChild(TreeNode child) {
        childSet.add(child);
        child.setParent(this);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (childSet.contains(child)){
            childSet.remove(child);
            child.setParent(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;

        for (TreeNode node : childSet){
            node.setExpanded(expanded);
        }
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        String path = null;
        String current = data == null ? "empty" : data.toString();
        if (parent == null) {
            path = current;
        }
        else {
            path = parent.getTreePath() + "->" + current;
        }
        return path;
    }

    @Override
    public TreeNode findParent(Object data) {
        if (((data == null) && (this.getData() == null)) || (this.getData().equals(data))){
            return this;
        }
        if (parent == null){
            return null;
        }
        return parent.findParent(data);
    }

    @Override
    public TreeNode findChild(Object data) {
        for (TreeNode node : childSet){

            if (data == null) {
                if (node.getData() == null){
                    return node;
                }
            }

            else if (node.getData().equals(data)){
                return node;
            }

            else {
                TreeNode temp = node.findChild(data);
                if (temp != null){
                    return temp;
                }
            }
        }

        return null;
    }
}
