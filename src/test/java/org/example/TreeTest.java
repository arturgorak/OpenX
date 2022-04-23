package org.example;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

class TreeTest {
    Tree tree = new Tree();
    Tree tree2 = new Tree();

    void insert_set(){
        for(int i = 0; i < 7; i++){
            tree.insert(i);
        }
    }

    void insert_given_set(){
        int[] array = {5, 7, 3, 0, 1, 8, 2, 2, 5, 5};
        for(int i: array){
            tree2.insert(i);
        }
    }

    @org.junit.jupiter.api.Test
    void insert() {

        insert_set();
        int[] expected = {2, 0, 4, 1, 6, 3, 5};
        ArrayList<Integer> result = tree.inorder();

        for(int i = 0; i < 7; i++){
            Assertions.assertEquals(expected[i], result.get(i));
        }

    }

    @org.junit.jupiter.api.Test
    void depth_left_subtree() {
        insert_set();
        Assertions.assertEquals(2, tree.depth_left_subtree());
    }

    @org.junit.jupiter.api.Test
    void depth_left_subtree_when_most_left_leaf_has_no_brother() {
        insert_set();
        tree.insert(7);
        Assertions.assertEquals(2, tree.depth_left_subtree());
    }

    @org.junit.jupiter.api.Test
    void depth_left_subtree_when_most_left_leaf_has_brother() {
        insert_set();
        tree.insert(7);
        tree.insert(8);
        Assertions.assertEquals(3, tree.depth_left_subtree());
    }

    @org.junit.jupiter.api.Test
    void depth_right_subtree() {
        insert_set();
        Assertions.assertEquals(4, tree.depth_right_subtree());
    }

    @org.junit.jupiter.api.Test
    void depth_right_subtree_when_most_right_leaf_has_no_brother() {
        insert_set();
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        Assertions.assertEquals(4, tree.depth_right_subtree());
    }

    @org.junit.jupiter.api.Test
    void depth_right_subtree_when_most_right_leaf_has_brother() {
        insert_set();
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        Assertions.assertEquals(5, tree.depth_right_subtree());
    }

    @org.junit.jupiter.api.Test
    void leaves() {
        insert_set();
        Assertions.assertEquals(4, tree.leaves());
    }

    @org.junit.jupiter.api.Test
    void edges() {
        insert_set();
        Assertions.assertEquals(3, tree.edges());
    }

    @org.junit.jupiter.api.Test
    void equals() {
        insert_set();
        Tree tmp = new Tree();

        for(int i = 0; i < 7; i++){
            tmp.insert(i);
        }
        Assertions.assertEquals(tree, tmp);
        Assertions.assertEquals(tmp, tree);
        Assertions.assertEquals(tree, tree);
    }

    @org.junit.jupiter.api.Test
    void not_equals() {
        insert_set();
        Tree tmp = new Tree();

        for(int i = 0; i < 7; i++){
            tmp.insert(i + 1);
        }
        Assertions.assertNotEquals(tree, tmp);
        Assertions.assertNotEquals(tmp, tree);
    }

    @org.junit.jupiter.api.Test
    void insert_given_data() {
        insert_given_set();
        int[] expected = {2, 3, 5, 5, 1, 7, 2, 0, 8, 5};
        ArrayList<Integer> result = tree2.inorder();

        for(int i = 0; i < expected.length; i++){
            Assertions.assertEquals(expected[i], result.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void depth_left_subtree_on_given_data() {
        insert_given_set();
        Assertions.assertEquals(3, tree2.depth_left_subtree());
    }

    @org.junit.jupiter.api.Test
    void depth_right_subtree_on_given_data() {
        insert_given_set();
        Assertions.assertEquals(4, tree2.depth_right_subtree());
    }

    @org.junit.jupiter.api.Test
    void leaves_on_given_data() {
        insert_given_data();
        Assertions.assertEquals(5, tree2.leaves());
    }

    @org.junit.jupiter.api.Test
    void edges_on_given_data() {
        insert_given_data();
        Assertions.assertEquals(4, tree2.edges());
    }



}