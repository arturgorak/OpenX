package org.example;

import java.util.ArrayList;

public class Tree {
    static class Node {
        int val;
        Node left, right;
        public Node(int value) {
            val = value;
            left = right = null;
        }
    }

    Node root;
    Tree() { root = null; }

    Tree(int value) { root = new Node(value); }

    void insert(int key) {
        if(depth_right_subtree() - depth_left_subtree() == 2){
            root = insert_left_subtree(root, key);
        } else {
            root = insert_right_subtree(root, key);
        }
    }
    
    int depth_left_subtree(){
        return depth_left_subtree_recursive(root);
    }

    int depth_left_subtree_recursive(Node node){
        if(node == null){
            return 1;
        } else if(node.right == null){
            return 1;
        } else {
            return depth_left_subtree_recursive(node.left) + 1;
        }
    }

    int depth_right_subtree(){
        return depth_right_subtree_recursive(root);
    }

    int depth_right_subtree_recursive(Node node){
        if(node == null){
            return 1;
        } else if(node.left == null){
            return 1;
        } else {
            return depth_right_subtree_recursive(node.right) + 1;
        }
    }

    Node insert_right_subtree(Node root, int key){
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (root.right == null) {
            root.right = new Node(key);
        } else if (root.left == null) {
            root.left = new Node(key);
        } else{
            root.right = insert_right_subtree(root.right, key);
        }
        return root;
    }

    Node insert_left_subtree(Node root, int key){
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (root.left == null) {
            root.left = new Node(key);
        } else if (root.right == null) {
            root.right = new Node(key);
        } else{
            root.left = insert_left_subtree(root.left, key);
        }
        return root;
    }

    ArrayList<Integer> inorder() {
        ArrayList<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }

    void inorderRec(Node root, ArrayList<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.val);
            //System.out.println(root.val);
            inorderRec(root.right, result);
        }
    }

    int leaves(){
        return leaves_recursive(root);
    }

    int leaves_recursive(Node root){
        if(root == null){
            return 0;
        }else if(root.right == null && root.left == null){
            return 1;
        } else{
            return leaves_recursive(root.left) + leaves_recursive(root.right);
        }
    }

    int height_recursive(Node root){
        if(root == null){
            return 0;
        } else {
            return height_recursive(root.right) + 1;
        }
    }
    int edges(){
        return height_recursive(root) - 1;
    }

    boolean identicalTrees(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null) {
            return (a.val == b.val && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Tree c)) {
            return false;
        }
        return identicalTrees(root, c.root);
    }
}




