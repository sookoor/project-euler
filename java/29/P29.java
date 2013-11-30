

import java.lang.Math;
import java.util.*;

class P29 {

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

    int n = 100;

    // All distinct representations
    HashSet<String> repSet = new HashSet<String>();

    // All primes
    ArrayList<Integer> primes = new ArrayList<Integer>();

    // Complexity: O(N^2)
    for (int a=2;a<=n;a++) {

      LinkedList<Integer> factors = new LinkedList<Integer>();
      if (isPrime(a)) {
        // a is prime
        factors.add(a);
        factors.add(1);

        primes.add(a);
      } else {
        // Factorize a with previous primes.
        int x = a;
        Iterator<Integer> p = primes.listIterator();

        while (x > 1 && p.hasNext()) {
          int factor = p.next();
          int power = 0;
          while (x%factor == 0) {
            power++;
            x = x/factor;
          }
          if (power > 0) {
            factors.add(factor);
            factors.add(power);
          }
        }
      }

      StringBuilder rep = new StringBuilder();
      // Build representation for each a^b
      for (int b=2;b<=n;b++) {
        Iterator<Integer> itr = factors.listIterator();
        while (itr.hasNext()) {
          rep.append(itr.next() + "^"+ (itr.next()*b) + ",");
        }
        // add representation to the set
        repSet.add(rep.toString());
        rep.setLength(0);
      }
    }

    System.out.println(repSet.size());
  }

}
