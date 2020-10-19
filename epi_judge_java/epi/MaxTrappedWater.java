package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxTrappedWater {
  @EpiTest(testDataFile = "max_trapped_water.tsv")

  // THIS WORKS ON LEETCODE... THERE MUST BE ANOTHER CATCH IN THE BOOK TO READ ABOUT
  public static int getMaxTrappedWater(List<Integer> heights) {
    if (heights == null || heights.isEmpty()) return 0;

    List<Integer> left = getTrappedWaterFromLeftBound(heights);

    List<Integer> heightsReversed = new ArrayList<>(heights); Collections.reverse(heightsReversed);

    List<Integer> right = getTrappedWaterFromLeftBound(heightsReversed); Collections.reverse(right);

    int sum = 0;
    for (int i = 0; i < heights.size(); i++) sum += (Math.min(left.get(i), right.get(i)));

    return sum;
  }

  public static List<Integer> getTrappedWaterFromLeftBound(List<Integer> heights){
    List<Integer> result = new ArrayList<>(heights.size());
    result.add(0);
    int retentionCap = heights.get(0);
    for (int i = 1; i < heights.size(); i++) {
      if (heights.get(i) < retentionCap){
        result.add(retentionCap - heights.get(i));
      } else {
        retentionCap = heights.get(i);
        result.add(0);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MaxTrappedWater.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
