

import java.lang.Math;
import java.util.*;

class P41 {

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



  public static interface Ops {
    void invoke(int[] tokens);
  }

  /**
   * Permutate tokens to all possible ways and invoke input operation
   *
   * Complexity: O(N!) where N is the number of tokens
   */
  public static void permute(int[] token, int start, Ops ops) {
    if (token.length-1 <= start) {
      ops.invoke(token);
      return;
    }

    permute(token, start+1, ops);
    for (int i=start+1;i<token.length;i++) {
      int tmp = token[start];
      token[start] = token[i];
      token[i] = tmp;
      permute(token, start+1, ops);
      token[i] = token[start];
      token[start] = tmp;
    }
  }

  public static void main(String[] args) {
    int[] d = new int[] {9,8,7,6,5,4,3,2,1}; // digits

    long ans = 0;

    // Complexity: O(NxN!) where N is number of digits (9)
    for (int start=0;start<d.length;start++) {

      final PriorityQueue<Long> primes = new PriorityQueue<Long>();

      final int s = start;

      // Permute digits
      permute(d, start, new Ops() {
        public void invoke(int[] tokens) {
          long x = 0;
          // Construct the number from the array.
          for (int i=s;i<tokens.length;i++) {
            x = x*10 + tokens[i];
          }

          // Check if it is prime.
          if (isPrime(x)) {
            primes.add(x);
          }
        }
      });

      if (!primes.isEmpty()) {
        // Find the max primes from answer.
        while (!primes.isEmpty()) {
          ans = primes.poll();
        }
        break;
      }
    }

    System.out.println(ans);
  }

}
