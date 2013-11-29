

import java.util.*;

class P26 {

  public static void main(String[] args) {
    int n = 1000;


    // Complexity: O(N) which N is the limit of d.
    int d = 1;
    int maxRecurLen = 0;
    int maxRecurD = d;
    while (++d < n) {
      HashSet<Integer> remainder = new HashSet<Integer>();

      int numerator = 1;
      int recurLen = 0;
      while (numerator > 0 && !remainder.contains(numerator)) {
        if (numerator > d) {
          remainder.add(numerator);
          numerator = numerator % d;
          recurLen++;
        } else {
          numerator *= 10;
        }
      }

      if (numerator > 0 && recurLen > maxRecurLen) {
        maxRecurLen = recurLen;
        maxRecurD = d;
      }
    }

    System.out.println(maxRecurD);
  }

}
