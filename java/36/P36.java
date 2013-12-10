

import java.lang.Math;
import java.util.*;


class P36 {

  /**
   * Check if the number is palindrome
   */
  public static boolean isPalindrome(int n, int base) {
    int start = n;
    int reverse = 0;

    while (start != 0) {
      int r = start % base;
      reverse = reverse*base + r;
      start = start/base;
    }

    return n == reverse;
  }

  public static void main(String[] args) {

    int limit = 1000000;

    // Complexity: O(ND) where N is the limit and D is number of digits of the limit.
    int sum = 0;
    for (int a=1;a<limit;a++) {
      if (isPalindrome(a, 10) && isPalindrome(a, 2)) {
        sum += a;
      }
    }

    System.out.println(sum);
  }

}
