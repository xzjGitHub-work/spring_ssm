package com.myself.demo1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/11/16 16:18
 */
@Getter
@Setter
@ToString
public class Node {
    public Node left;
    public Node right;
    public Node root;
    //    数据域
    private Object data;
    //    存节点
    public List<Node> datas;
    //集合 链表 数据结构

    //先序遍历
    public void preorder(Node root) {
        //  队列 堆栈 红黑树 b+tree 二叉树 哈希表
        String[] array ={"1", "2"};
        ArrayList<Object> list = new ArrayList<>();// 集合
        LinkedList<Object> list1 = new LinkedList<>(); //  链表

        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }


    //创建树
    public void creat(Object[] objs) {
        datas = new ArrayList<>();
        for (Object o : objs) {
            datas.add(new Node(o));
        }
        root = datas.get(0);
        for (int i = 0; i < objs.length / 2; i++) {
            datas.get(i).left = datas.get(i * 2 + 1);
            if (i * 2 + 2 < datas.size()) {
                datas.get(i).right = datas.get(i * 2 + 2);
            }
        }
    }

    public Node() {}
    public Node(Object data) {
        this(null, null, data);
    }


    public Node(Node left, Node right, Object data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }


    public static void main(String[] args) {
        Node demo = new Node();
        Object[] a = {2, 4, 5, 7, 1, 6, 12, 32, 51, 22};
        demo.creat(a);
        demo.preorder(demo.root);

    }
}
