

import java.lang.Math;
import java.util.*;

class P46 {

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

  /**
   * Check if the number is square.
   */
  public static boolean isSquare(int n) {
    int x = (int)Math.sqrt(n);
    return (x*x == n);
  }


  public static void main(String[] args) {
    long ans = 0;
    LinkedList<Integer> primes = new LinkedList<Integer>();
    primes.add(2);

    // Complexity: O(N^2) where N is the answer
    for (int a=3;ans == 0;a+=2) {
      if (isPrime(a)) {
        primes.add(a);
        continue;
      }

      boolean found = false;
      for (Integer p : primes) {
        if ((a-p)%2 == 0 && isSquare((a-p)/2)) {
          found = true;
          break;
        }
      }

      if (!found) {
        ans = a;
      }
    }

    System.out.println(ans);
  }

}
