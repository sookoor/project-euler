


import java.lang.Math;
import java.util.*;

class P47 {

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
    long ans = 0;
    int limit = 4;
    LinkedList<Integer> primes = new LinkedList<Integer>();

    // Complexity: O(N^2) where N is the answer
    int consecutive = 0;
    for (int a=2;consecutive < limit;a++) { // until found the specific consecutive numbers
      if (isPrime(a)) { // Skip prime
        consecutive = 0;
        primes.add(a);
        continue;
      }

      int n = 0;
      int x = a;
      for (Integer p : primes) { // Count prime factors
        if (x%p != 0) {
          continue;
        }
        n++;
        while (x%p == 0) {
          x = x/p;
        }
      }

      if (n == limit) { // needed number of prime factors
        consecutive++;
        if (consecutive == 1) {
          ans = a;
        }
      } else {
        consecutive = 0;
      }
    }

    System.out.println(ans);
  }

}
