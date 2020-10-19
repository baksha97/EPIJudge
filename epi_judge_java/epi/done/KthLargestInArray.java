package epi.done;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInArray {
  // The numbering starts from one, i.e., if A = [3,1,-1,2] then
  // findKthLargest(1, A) returns 3, findKthLargest(2, A) returns 2,
  // findKthLargest(3, A) returns 1, and findKthLargest(4, A) returns -1.
  @EpiTest(testDataFile = "kth_largest_in_array.tsv")
  public static int findKthLargest(int k, List<Integer> A) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(k);
    for (int i = 0; i < k; i++) pq.add(A.get(i));
    for (int i = k; i < A.size(); i++) {
      if (pq.peek() < A.get(i)){
        pq.poll();
        pq.offer(A.get(i));
      }
    }

    return pq.peek();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KthLargestInArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
