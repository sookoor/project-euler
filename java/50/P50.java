


import java.lang.Math;
import java.util.*;

class P50 {

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

    // Complexity: O(N^2) where N is limit
    LinkedList<Integer> primes = new LinkedList<Integer>();

    int ans = 0;
    int seq = 0;
    for (int n=1;n<limit;n++) {
      if (isPrime(n)) {
        primes.add(n);
        Iterator<Integer> itr = primes.descendingIterator();
        int sum = 0;
        int seqCount = 0;
        while (itr.hasNext()) {
          sum += itr.next();
          if (sum > limit) break;
          if (++seqCount > seq && isPrime(sum)) {
            seq = seqCount;
            ans = sum;
          }
        }
      }
    }

    System.out.println(ans);
  }

}
