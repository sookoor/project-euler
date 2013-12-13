

import java.lang.Math;
import java.util.*;

class P39 {

  public static void main(String[] args) {

    int limit = 1000;

    // Complexity: O(N^3) where N is the limit
    int ans = 0;
    int maxNum = 0;
    for (int p=3;p<=limit;p++) { // populate p
      int n = 0;

      for (int c=2;c<p;c++) { // populate c
        for (int a=1;a<p-c && a<c && a <=(p-c)/2;a++) {
          int b = p - c - a;
          if (a*a + b*b == c*c) {
            n++;
          }
        }
      }

      // Check max
      if (n > maxNum) {
        maxNum = n;
        ans = p;
      }
    }

    System.out.println(ans);
  }

}
