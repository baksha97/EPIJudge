package epi.done;
import epi.BinaryTreeNode;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class TreeLevelOrder {
  @EpiTest(testDataFile = "tree_level_order.tsv")

  public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
    List<List<Integer>> result = new ArrayList<>();
    addLevelLists(tree, result, 0);
    return result;
  }

  private static void addLevelLists(BinaryTreeNode<Integer> tree, List<List<Integer>> result, int depth) {
    if (tree == null) return;
    // if at a new depth, make sure there is a corresponding level list for it.
    if(depth == result.size()) result.add(new ArrayList<>());
    result.get(depth).add(tree.data);
    addLevelLists(tree.left, result, depth + 1);
    addLevelLists(tree.right, result, depth + 1);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "TreeLevelOrder.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
