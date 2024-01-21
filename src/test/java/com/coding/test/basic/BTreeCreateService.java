package com.coding.test.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BTreeCreateService {
    static String answer = "";

    @Test
    public String test() {
        String message = "ABCDEF";
        CompleteBinaryTree tree = new CompleteBinaryTree();

        for (int i = 0; i <= message.length() - 1; i++) {
            tree.insert(String.valueOf(message.charAt(i)));
        }

        // 트리 출력
        System.out.println("완전 이진 트리 출력 (후위 순회):");
        tree.addTree(tree.root);
        return answer;

    }

    class TreeNode {
        String data;
        TreeNode left, right;

        public TreeNode(String item) {
            data = item;
            left = right = null;
        }
    }

    public class CompleteBinaryTree {
        TreeNode root;

        public void insert(String data) {
            if (root == null) {
                root = new TreeNode(data);
                return;
            }

            java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();

                if (temp.left == null) {
                    temp.left = new TreeNode(data);
                    break;
                } else {
                    queue.add(temp.left);
                }

                if (temp.right == null) {
                    temp.right = new TreeNode(data);
                    break;
                } else {
                    queue.add(temp.right);
                }
            }
        }

        public void addTree(TreeNode node) {
            if (node == null)
                return;

            addTree(node.left);
            addTree(node.right);
            answer += node.data;
        }
    }
}
