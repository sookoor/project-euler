

import java.lang.Math;
import java.util.*;

class P45 {

  public static boolean isPantagonal(long x) {
    /**
     * n(3n-1)/2 = Pn
     * 3n^2 - n = 2Pn
     * 36n^2 - 12n = 24Pn
     * (6n - 1)^2 = 24Pn + 1
     * 6n - 1 = sqrt(24Pn + 1)
     * n = (sqrt(24Pn + 1) + 1)/6
     */

    double k = (Math.sqrt(24*x + 1) + 1) / 6;
    return ((long)k == k);
  }

  public static boolean isHexagonal(long x) {
    /**
     * n(2n-1) = Hn
     * 16n^2 - 8n = 8Hn
     * 16n^2 - 8n + 1 = 8Hn + 1
     * (4n - 1)^2 = 8Hn + 1
     * 4n - 1 = sqrt(8Hn + 1)
     * n = (sqrt(8Hn + 1) + 1)/4
     */

    double k = (Math.sqrt(8*x + 1) + 1) / 4;
    return ((long)k == k);
  }

  public static long triangle(long n) {
    return (n+1) * n / 2;
  }

  public static void main(String[] args) {

    long ans = 0;

    // Complexity: O(N) where N is the number
    int n = 2;
    int next = 1;
    do {
      ans = triangle(n++);
    } while (!isPantagonal(ans) || !isHexagonal(ans) || next-- > 0);

    System.out.println(ans);
  }

}
