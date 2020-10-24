package epi.done;

import epi.BinaryTreeNode;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.util.BinaryTreePrinter;

public class IsTreeABst {

    @EpiTest(testDataFile = "is_tree_a_bst.tsv")
    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        BinaryTreePrinter p = new BinaryTreePrinter(tree);
        System.out.println("\n\n");
        p.print(System.out);
        System.out.println("\n\n");
        return isNodeBST(tree, null, null);
    }

    public static boolean isNodeBST(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> min, BinaryTreeNode<Integer> max) {
        if (node == null) return true;
        boolean isMinValid = min == null || min.data <= node.data;
        boolean isMaxValid = max == null || node.data <= max.data;
        return isMinValid && isMaxValid
                && isNodeBST(node.left, min, node)
                && isNodeBST(node.right, node, max);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args,
                                "IsTreeABst.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}