

import java.lang.Math;
import java.util.*;

class P44 {

  public static boolean isPantagonal(int x) {
    /**
     * n(3n-1)/2 = Pn
     * 3n^2 - n = 2Pn
     * 36n^2 - 12n = 24Pn
     * (6n - 1)^2 = 24Pn + 1
     * 6n - 1 = sqrt(24Pn + 1)
     * n = (sqrt(24Pn + 1) + 1)/6
     */

    double k = (Math.sqrt(24*x + 1) + 1) / 6;
    return ((int)k == k);
  }

  public static void main(String[] args) {

    int ans = 0;
    LinkedList<Integer> pantagonal = new LinkedList<Integer>();

    // Complexity: O(N^2) where N is numbers
    for (int i=1;ans == 0;i++) {
      int pk = (i * (3*i - 1))/2;

      Iterator<Integer> itr = pantagonal.descendingIterator();
      while (itr.hasNext()) {
        int pj = itr.next();
        if (isPantagonal(pk+pj) && isPantagonal(pk-pj)) {
          ans = pk-pj;
          break;
        }
      }

      pantagonal.add(pk);
    }

    System.out.println(ans);
  }

}
