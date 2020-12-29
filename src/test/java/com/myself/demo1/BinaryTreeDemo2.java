package com.myself.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/11/16 11:24
 */
public class BinaryTreeDemo2 {
    public static void main(String[] args) {
        Node demo = new Node();
        Object[] a = {2, 4, 5, 7, 1, 6, 12, 32, 51, 22};
        demo.creat(a);
        demo.preorder(demo.root);

    }
}
