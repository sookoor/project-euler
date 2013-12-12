

import java.lang.Math;
import java.util.*;

class P38 {


  /**
   * Check the digits of number against the digits array
   *
   * @return number of seeking digits left.
   */
  public static int check(boolean[] digits, int n, int left) {
    while (n>0) {
      int x = n%10;
      if (x == 0 || digits[x]) {
        return -1;
      } else {
        left--;
        digits[x] = true;
      }
      n = n/10;
    }
    return left;
  }

  public static void main(String[] args) {

    int limit = 100000;
    String ans = "";

    // Complexity: O(ND) where N is the limit and D is number of digits of the limit
    for (int x=limit;x>0;x--) {

      int n=1;
      boolean[] digits = new boolean[10];
      int left = 9;
      while (left > 0) {
        // Check each product of x with the digits array
        left = check(digits, x*n, left);
        n++;
      }

      if (left == 0) {
        // Found the pandigital number. Let's build the answer.
        while (--n>0) {
          ans = (x*n) + ans;
        }
        ans = x +": "+ans;
        break;
      }

    }

    System.out.println(ans);
  }

}
