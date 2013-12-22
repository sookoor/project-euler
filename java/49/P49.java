

import java.lang.Math;
import java.util.*;

class P49 {

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

  public static boolean check(int[] tokens, int start, int div) {
    int x = tokens[start-1]*100 + tokens[start]*10 + tokens[start+1];
    return (x%div) == 0;
  }

  public static void main(String[] args) {

    // Complexity: O(NxN!) where N is number of digits (4)
    HashSet<String> ans = new HashSet<String>();

    for (int n=1000;n<10000;n++) {
      if (!isPrime(n)) continue;

      int[] d = new int[4];
      d[0] = n%10;
      d[1] = (n/10)%10;
      d[2] = (n/100)%10;
      d[3] = (n/1000)%10;
      if (d[0]*d[1]*d[2]*d[3] == 0) {
        continue;
      }

      final TreeSet<Integer> seq = new TreeSet<Integer>();

      permute(d, 0, new Ops() {
        public void invoke(int[] t) {

          int x = t[3] * 1000 + t[2]*100 + t[1]*10 + t[0];
          if (isPrime(x)) {
            seq.add(x);
          }
        }
      });

      if (seq.size() >= 3) {
        int prev = 0;
        for (int s1 : seq) {
          for (int s2 : seq.tailSet(s1,false)) {
            int df = s2-s1;
            if (seq.contains(s1+df) && seq.contains(s1+df+df)) {
              ans.add(s1+":"+(s1+df)+":"+(s1+df+df));
            }
          }
        }
      }
    }

    for (String s:ans) {
      System.out.println(s);
    }
  }

}
