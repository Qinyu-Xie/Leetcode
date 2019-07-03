package topInterviewQuestions.easy.trees;

import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    private static boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return isSymmetricRec(root.left, root.right);
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }

        return true;
    }

    private static boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);
    }
}
