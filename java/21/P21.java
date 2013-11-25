



import java.util.LinkedList;
import java.util.HashSet;
import java.util.ListIterator;

class P21 {

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

  public static void main(String[] args) {
    int n = 10000;

    int[] cache = new int[n];
    cache[0] = 1;

    int sum = 0;

    // Complexity: O(n^2) which n is the number
    for (int a = 1; a <= n; a++) {
      int b = sumOfDivisors(cache, a);
      if (b <= n && b != a && sumOfDivisors(cache, b) == a) {
        System.out.println("d("+a+")="+b +" and d("+b+")="+a);
        sum += a;
      }
    }

    System.out.println(sum);
  }

}
