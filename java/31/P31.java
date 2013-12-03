

import java.lang.Math;
import java.util.*;

class P31 {

  public static int ways(int left, int[] coins, int sc) {
    if (left == 0) { return 1; }
    if (left < 0) return 0;

    int w = 0;
    for (int i=sc; i<coins.length; i++ ) {
      w += ways(left-coins[i] , coins, i);
    }

    return w;
  }

  public static void main(String[] args) {
    int max = 200;

    int[] coins = new int[]{ 200, 100, 50, 20, 10, 5, 2, 1 };

    int w = ways(max, coins, 0);

    System.out.println(w);
  }

}
