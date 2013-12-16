

import java.lang.Math;
import java.util.*;

class P43 {

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
    int[] d = new int[] {9,8,7,6,5,4,3,2,1,0}; // digits

    final HashSet<Long> ans = new HashSet<Long>();

    // Complexity: O(N!) where N is number of digits (10)

    permute(d, 0, new Ops() {
      public void invoke(int[] tokens) {

        if (check(tokens, 2, 2)
          && check(tokens, 3, 3)
          && check(tokens, 4, 5)
          && check(tokens, 5, 7)
          && check(tokens, 6, 11)
          && check(tokens, 7, 13)
          && check(tokens, 8, 17)) {

          long num = 0;
          long step = 1;
          for (int i = tokens.length-1;i>=0;i--) {
            num += tokens[i] * step;
            step *= 10;
          }
          ans.add(num);
        }
      }
    });

    long sum = 0;
    for (long x : ans) {
      sum += x;
    }
    System.out.println(sum);
  }

}
