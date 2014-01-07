

import java.lang.Math;
import java.util.*;

class P52 {

  /**
   * Check if the number is permuted multiples.
   */
  public static boolean isPermutedMultiples(long n, int t) {

    long x = 0;
    TreeSet<Integer> q1 =  null;
    int qn1 = 0;

    for (int i=1;i<=t;i++) {
      x = n*i;
      TreeSet<Integer> q2 = new TreeSet<Integer>();
      int qn2 = 0;
      while (x > 0) {
        int d = (int)(x % 10L);
        x = x/10;
        q2.add(d);
        qn2++;
      }

      if (q1 == null) {
        q1 = q2;
        qn1 = qn2;
      }
      if (qn1 != qn2 || !q1.equals(q2)) return false;
      t--;
    }

    return true;
  }

  public static void main(String[] args) {

    // Complexity: O(Nd) where N is limit and d is the digits of the number
    long ans = 1;
    for (;;ans++) {
      if (isPermutedMultiples(ans, 6)) {
        break;
      }
    }

    System.out.println(ans);
  }

}
