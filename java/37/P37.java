

import java.lang.Math;
import java.util.*;


class P37 {

  /**
   * Check if the number is prime
   */
  public static boolean isPrime(long n) {

    if (n == 1)return false;
    else if (n<4) return true; //2 and 3 are prime
    else if (n % 2 == 0) return false;
    else if (n<9) return true;
    else if (n % 3 == 0) return false;
    else {
      long r = (long)Math.floor(Math.sqrt(n)); // n rounded to the greatest integer r so that r*r<=n
      long f = 5;
      while (f<=r) {
        if (n % f ==0) return false;
        if (n % (f+2) ==0) return false;
        f=f+6;
      }
      return true;
    }
  }

  public static void main(String[] args) {

    // Complexity: O(ND) where N is the greatest truncatable primes and D is the number of digits of the number
    int sum = 0;
    int limit = 11;
    int a = 10;
    int step = 10;
    while (limit > 0) {

      if (a == step*10) {
        step *= 10;
      }

      int x1 = a;
      int x2 = a;
      int d = step;
      while (x1 > 0 && x2 > 0 && isPrime(x1) && isPrime(x2)) {
        x1 = x1/10;
        x2 = x2%d;
        d /= 10;
      }

      if (x1 == 0 && x2 ==0) {
        limit--;
        sum += a;
      }
      a++;

    }

    System.out.println(sum);
  }

}
