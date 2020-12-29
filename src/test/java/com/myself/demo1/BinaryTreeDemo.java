package com.myself.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/11/16 11:24
 */
public class BinaryTreeDemo {
    public BinaryTreeDemo left;
    public BinaryTreeDemo right;
    public BinaryTreeDemo root;
    //    数据域
    private Object data;
    //    存节点
    public List<BinaryTreeDemo> datas;

    public BinaryTreeDemo(BinaryTreeDemo left, BinaryTreeDemo right, Object data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    //    将初始的左右孩子值为空
    public BinaryTreeDemo(Object data) {
        this(null, null, data);
    }

    public BinaryTreeDemo() {

    }

    public static void main(String[] args) {
        BinaryTreeDemo demo = new BinaryTreeDemo();
        Object[] a = {2, 4, 5, 7, 1, 6, 12, 32, 51, 22};
        demo.creat(a);
        demo.preorder(demo.root);

    }

    public void creat(Object[] objs) {
        datas = new ArrayList<>();
        //将一个数组的值依次转换为Node节点
        for (Object o : objs) {
            datas.add(new BinaryTreeDemo(o));
        }
//        第一个数为根节点
        root = datas.get(0);
//        建立二叉树
        for (int i = 0; i < objs.length / 2; i++) {
            datas.get(i).left = datas.get(i * 2 + 1);
            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
                datas.get(i).right = datas.get(i * 2 + 2);
            }
        }
    }

    //先序遍历
    public void preorder(BinaryTreeDemo root) {
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    //中序遍历
    public void inorder(BinaryTreeDemo root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    //    后序遍历
    public void afterorder(BinaryTreeDemo root) {
        if (root != null) {
            System.out.println(root.data);
            afterorder(root.left);
            afterorder(root.right);
        }
    }
}
