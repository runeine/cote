package com.example.demo.cote;

import java.util.ArrayList;
import java.util.List;

public class NodeFind {

    static class TreeNode {
        int x, y;
        TreeNode left, right;
        int seq;

        TreeNode(int x, int y) {
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
        public int setSeq(int seq){
            return this.seq = seq;
        }
    }

    public TreeNode insert(TreeNode root, int x, int y) {
        if (root == null) {
            return new TreeNode(x, y);
        }
        if (x < root.x) {
            root.left = insert(root.left, x, y);
        } else {
            root.right = insert(root.right, x, y);
        }
        return root;
    }

    public TreeNode buildTree(int[][] coordinates) {
        TreeNode root = null;
        int seq = 0;
        for (int[] coordinate : coordinates) {
            // root.setSeq(seq);
            root = insert(root, coordinate[0], coordinate[1]);
            // seq++;
        }
        return root;
    }

    public void preOrder(TreeNode node, List<int[]> result) {
        if (node == null) return;
        result.add(new int[]{node.x, node.y});
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    public void postOrder(TreeNode node, List<int[]> result) {
        if (node == null) return;
        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(new int[]{node.x, node.y});
    }

    public int[][] solution(int[][] nodeinfo) {
        TreeNode root = buildTree(nodeinfo);
        List<int[]> preOrderResult = new ArrayList<>();
        List<int[]> postOrderResult = new ArrayList<>();
        preOrder(root, preOrderResult);
        postOrder(root, postOrderResult);

        int[][] result = new int[2][];
        result[0] = preOrderResult.stream().flatMapToInt(arr -> java.util.Arrays.stream(arr)).toArray();
        result[1] = postOrderResult.stream().flatMapToInt(arr -> java.util.Arrays.stream(arr)).toArray();
        return result;
    }

    public static void main(String[] args) {
        NodeFind nf = new NodeFind();
        int[][] input = new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] result = nf.solution(input);

        // Print pre-order and post-order traversal results
        System.out.println("Pre-order traversal:");
        for (int i = 0; i < result[0].length; i += 2) {
            System.out.print("[" + result[0][i] + ", " + result[0][i + 1] + "] ");
        }
        System.out.println();

        System.out.println("Post-order traversal:");
        for (int i = 0; i < result[1].length; i += 2) {
            System.out.print("[" + result[1][i] + ", " + result[1][i + 1] + "] ");
        }
    }
}