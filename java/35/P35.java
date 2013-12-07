

import java.lang.Math;
import java.util.*;


class P35 {

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

    int limit = 1000000;

    HashSet<Integer> cirPrimes = new HashSet<Integer>();


    // Complexity: O(NlogN) where N is the limit

    int step = 10;
    HashSet<Integer> p = new HashSet<Integer>();
    for (int a=2; a<limit; a++) {

      if (a == step) {
        step *= 10;
      }

      if (!cirPrimes.contains(a) && isPrime(a)) {
        p.clear();

        int x = a;
        // Rotate digits and check
        do {
          x = (x/10) + x%10 * (step / 10);

          if (isPrime(x)) {
            p.add(x);
          } else {
            p.clear();
            break;
          }
        } while (x != a);

        cirPrimes.addAll(p);
      }
    }

    System.out.println(cirPrimes.size());
  }

}
