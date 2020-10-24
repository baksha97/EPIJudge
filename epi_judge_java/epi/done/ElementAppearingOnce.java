package epi.done;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElementAppearingOnce {
  @EpiTest(testDataFile = "element_appearing_once.tsv")

  public static int findElementAppearsOnce(List<Integer> A) {

    final Optional<Map.Entry<Integer, Long>> onlyOnce = A
            .stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(integerLongEntry -> integerLongEntry.getValue() == 1)
            .findFirst();

    return onlyOnce.isPresent() ? onlyOnce.get().getKey() : -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ElementAppearingOnce.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
