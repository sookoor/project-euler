

import java.lang.Math;
import java.util.*;

class P53 {

  // C(n,r) = (n..r+1)/(n-r)!
  // C(n+1,r) = (n+1)(n..r+1)/(n-r)!(n+1-r)
  // C(n+1,r) = (n+1)/(n+1-r)C(n,r)

  public static void main(String[] args) {

    // Complexity: O(N^2) where N is limit

    int ans = 0;
    int limit = 100;

    for (int r=1;r<=limit;r++) {
      int x = 1;
      for (int n=r;n<=limit-1;n++) {
        x = x*(n+1)/(n+1-r);
        if (x >= 1000000) {
          ans += limit - n;
          break;
        }
      }
    }

    System.out.println(ans);
  }

}
