package com.myself.demo1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Huffman {

    private static class TreeNode implements Comparable<TreeNode>{
        TreeNode left;
        TreeNode right;
        Double weight;
        char ch;
        String code;

        public TreeNode(Double weight,TreeNode left,TreeNode right) {
            this.weight = weight;
            this.left = left;
            this.right = right;
            this.code = "";
        }
        @Override
        public int compareTo(TreeNode o) {
            if (this.weight > o.weight) {
                return 1;
            }else if (this.weight < o.weight) {
                return -1;
            }else {
                return 0;
            }   
        }
    }

    public static TreeNode huffman(TreeMap<Double, Character> data) {
        TreeSet<TreeNode> tNodes = new TreeSet<>();
        Set<Double> weights = data.keySet();
        Iterator<Double> iterator = weights.iterator();
        while (iterator.hasNext()) {
            Double weight = iterator.next();
            TreeNode tmp = new TreeNode(weight, null, null);
            tmp.ch = data.get(weight);
            tNodes.add(tmp);
        }
        while (tNodes.size() > 1) {
            TreeNode leftNode = tNodes.pollFirst();
            leftNode.code = "0";
            TreeNode rightNode = tNodes.pollFirst();
            rightNode.code = "1";
            TreeNode newNode = new TreeNode(leftNode.weight+rightNode.weight,leftNode, rightNode);
            tNodes.add(newNode);
        }
        return tNodes.first();
    }

    private static void code(TreeNode t) {
        if (t.left != null) {
            t.left.code = t.code + t.left.code;
            code(t.left);
        }
        if (t.right != null) {
            t.right.code = t.code + t.right.code;
            code(t.right);
        }
    }

    public static void print(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                System.out.println(root.ch + " 编码：" + root.code);
            }else {
                print(root.left);
                print(root.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeMap<Double, Character> test = new TreeMap<>();
        test.put(0.10, 'h');
        test.put(0.21, 'g');
        test.put(0.03, 'f');
        test.put(0.32, 'e');
        test.put(0.06, 'c');
        test.put(0.02, 'b');
        test.put(0.19, 'd');
        test.put(0.07, 'a');

        TreeNode root = huffman(test);
        code(root);
        print(root);
    }

}
