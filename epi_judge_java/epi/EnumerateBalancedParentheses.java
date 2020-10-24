package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.function.BiPredicate;
public class EnumerateBalancedParentheses {
  @EpiTest(testDataFile = "enumerate_balanced_parentheses.tsv")

  public static List<String> generateBalancedParentheses(int numPairs) {
    List<String> result = new ArrayList<>();
    result.add("");
    for (int i = 0; i < numPairs; i++) {
      result = addAnAdditionalPair(result);
    }
    return result;
  }

  private static List<String> addAnAdditionalPair(List<String> pairs) {
    Set<String> result = new HashSet<>();
    for (String pair : pairs) {
      result.add("()" + pair);
      result.add(pair + "()");
      result.add("(" + pair + ")");
    }

    return new ArrayList<>(result);
  }

  @EpiTestComparator
  public static boolean comp(List<String> expected, List<String> result) {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EnumerateBalancedParentheses.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
