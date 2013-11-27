

import java.util.*;

class P23 {

  /**
   * Find sum of divisors of the number with memoization
   *
   * Complexity: O(n) which n is the number
   */
  public static int sumOfDivisors(int[] cache, int n) {
    if (cache[n-1] > 0) return cache[n-1];

    HashSet<Integer> divs = new HashSet<Integer>();
    for (int i = 1; i<n;i++) {
      if (n % i == 0) {
        divs.add(i);
      }
    }
    for (int a : divs) {
      cache[n-1] += a;
    }
    return cache[n-1];
  }

  /**
   * Check if the number can be expressed by two abundaant numbers
   *
   * Complexity: O(n) which n is number of abundant numbers
   */
  public static boolean expressedByTwo(int a, HashSet<Integer> abundants) {
    Iterator<Integer> itr = abundants.iterator();
    while (itr.hasNext()) {
      int ab = itr.next();
      if (abundants.contains(a - ab)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int limit = 28123;

    int[] cache = new int[limit];
    cache[0] = 1;

    int sum = 0;

    HashSet<Integer> abundants = new HashSet<Integer>();

    // Complexity: O(n^2) which n is the number
    for (int a = 1; a <= limit; a++) {
      if (sumOfDivisors(cache, a) > a) { // abundant number
        abundants.add(a);
      }

      if (!expressedByTwo(a, abundants)) { // if cannot be expressed by two abundant numbers
        sum += a;
      }
    }

    System.out.println(sum);
  }

}
