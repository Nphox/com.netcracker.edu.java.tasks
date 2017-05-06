package com.netcracker.edu.java.tasks;

import java.util.Iterator;

public class TestTreeNodeImpl {
    public static void testGetParent(){

    }

    public static void testSetParent(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();
        TreeNode d = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");
        d.setData("Data d");

        b.setParent(a);
        c.setParent(a);
        d.setParent(c);

        System.out.println(b.getParent().getData());
        System.out.println(c.getParent().getData());
        System.out.println(d.getParent().getData());

    }

    public static void testIsLeaf(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        b.addChild(c);

        System.out.println(a.isLeaf());
        System.out.println(b.isLeaf());
        System.out.println(c.isLeaf());
    }

    public static void testGetChildCount(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        a.addChild(c);

        System.out.println(a.getChildCount());
        System.out.println(b.getChildCount());
    }

    public static void testGetChildrenIterator(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        a.addChild(c);

        Iterator i = a.getChildrenIterator();

        for (;i.hasNext();){
            System.out.println(i.next());
        }
    }

    public static void testRemoveChild(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        System.out.println(a.removeChild(b));
        System.out.println(a.removeChild(c));
        System.out.println(b.getParent());
    }

    public static void testIsExpanded(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        b.addChild(c);
        System.out.println(a.isExpanded());
        System.out.println(a.isExpanded());
        System.out.println(b.isExpanded());
    }

    public static void testSetExpanded(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        b.addChild(c);

        System.out.println(a.isExpanded());
        System.out.println(b.isExpanded());
        System.out.println(c.isExpanded());
        System.out.println("");

        a.setExpanded(true);

        System.out.println(a.isExpanded());
        System.out.println(b.isExpanded());
        System.out.println(c.isExpanded());
        System.out.println("");

        b.setExpanded(false);

        System.out.println(a.isExpanded());
        System.out.println(b.isExpanded());
        System.out.println(c.isExpanded());
    }

    public static void testFindParent(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();


        String dataA = "Data a";
        String dataB = "Data b";
        String dataC = "Data c";
        String dataNull = null;

        a.setData(null);
        b.setData(dataB);
        c.setData(dataC);

        a.addChild(b);
        b.addChild(c);

        System.out.println(c.findParent(null).getData());
    }

    public static void testFindChild(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();
        TreeNode bc1 = new TreeNodeImpl();
        TreeNode bc2 = new TreeNodeImpl();
        TreeNode cc1 = new TreeNodeImpl();
        TreeNode cc2 = new TreeNodeImpl();

        String dataA = "Data a";
        String dataB = "Data b";
        String dataC = "Data c";
        String dataCC1 = "Data cc1";
        String dataCC2 = "Data cc2";
        String dataBC1 = "Data bc1";
        String dataBC2 = "Data bc2";
        String dataNull = null;

        a.setData(dataA);
        b.setData(dataB);
        c.setData(dataC);
        bc1.setData(dataBC1);
        bc2.setData(dataBC2);
        cc1.setData(dataCC1);
        cc2.setData(dataCC2);

        a.addChild(b);
        a.addChild(c);

        b.addChild(bc1);
        b.addChild(bc2);
        c.addChild(cc1);
        c.addChild(cc2);

        System.out.println(a.findChild(dataCC2).getData());
    }

    public static void testGetTreePath(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();
        TreeNode bc1 = new TreeNodeImpl();
        TreeNode bc2 = new TreeNodeImpl();
        TreeNode cc1 = new TreeNodeImpl();
        TreeNode cc2 = new TreeNodeImpl();

        String dataA = "Data a";
        String dataB = "Data b";
        String dataC = "Data c";
        String dataCC1 = "Data cc1";
        String dataCC2 = "Data cc2";
        String dataBC1 = "Data bc1";
        String dataBC2 = "Data bc2";
        String dataNull = null;

        a.setData(dataA);
        b.setData(dataB);
        c.setData(dataC);
        bc1.setData(dataBC1);
        bc2.setData(dataBC2);
        cc1.setData(dataCC1);
        cc2.setData(dataCC2);

        a.addChild(b);
        a.addChild(c);

        b.addChild(bc1);
        b.addChild(bc2);
        c.addChild(cc1);
        c.addChild(cc2);

        System.out.println(bc1.getTreePath());
        System.out.println(cc2.getTreePath());
    }

    public static void testGetRoot(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        b.addChild(c);

        System.out.println(a.getRoot());
        System.out.println(b.getRoot().getData());
        System.out.println(c.getRoot().getData());
    }

    public static void testAddChild(){
        TreeNode a = new TreeNodeImpl();
        TreeNode b = new TreeNodeImpl();
        TreeNode c = new TreeNodeImpl();

        a.setData("Data a");
        b.setData("Data b");
        c.setData("Data c");

        a.addChild(b);
        a.addChild(c);

        System.out.println(b.getParent().getData());
        System.out.println(c.getParent().getData());
    }

    public static void testGetData(){
        TreeNode a = new TreeNodeImpl();
        a.setData("Data 1");
        System.out.println(a.getData());
    }

    public static void testSetData(){
        TreeNode a = new TreeNodeImpl();
        a.setData("Data 1");
        System.out.println(a.getData());
    }

    public static void main(String... args){
        testGetTreePath();
    }
}
