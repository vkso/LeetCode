package com.company;
//import com.company.Solution;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Solution mySol = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        List<List<Integer>> res = mySol.levelOrder1(root);

        for (List<Integer> array: res) {
            for (Integer a: array) {
                System.out.print(a);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
