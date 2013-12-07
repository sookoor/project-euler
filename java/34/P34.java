

import java.lang.Math;
import java.util.*;

class P34 {

  public static int fac(int x) {
    switch(x) {
      case 0: return 1;
      case 1: return 1;
      case 2: return 2;
      case 3: return 2 * 3;
      case 4: return 2 * 3 * 4;
      case 5: return 2 * 3 * 4 * 5;
      case 6: return 2 * 3 * 4 * 5 * 6;
      case 7: return 2 * 3 * 4 * 5 * 6 * 7;
      case 8: return 2 * 3 * 4 * 5 * 6 * 7 * 8;
      case 9: return 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9;
    }
    return 1;
  }

  public static int sumDigitFac(int a) {
    int x = a;
    int sum = 0;
    while (x > 0) {
      sum += fac(x%10);
      x = x/10;
    }
    return sum;
  }

  public static void main(String[] args) {

    int sum = 0;

    // Complexity: O(N)
    for (int i = 10; i<10000000;i++) {
      if (i == sumDigitFac(i)) {
        sum += i;
      }
    }

    System.out.println(sum);
  }

}
