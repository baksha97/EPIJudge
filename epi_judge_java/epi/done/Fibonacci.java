package epi.done;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
  private static final Map<Integer, Integer> memo = new HashMap<>();

  @EpiTest(testDataFile = "fibonacci.tsv")
  public static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (memo.containsKey(n)) return memo.get(n);
    int res = fibonacci(n-1) + fibonacci(n-2);
    memo.put(n, res);
    return res;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Fibonacci.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
