


import java.lang.Math;
import java.util.*;

class P32 {

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
    int[] d = new int[] {1,2,3,4,5,6,7,8,9,10,11}; //10 is multiply sign, 11 is equal sign

    final HashSet<Integer> ans = new HashSet<Integer>();

    // Permutate digits and operators
    permute(d, 0, new Ops() {
      public void invoke(int[] tokens) {
        int operatorIth = -1;
        int equalIth = -1;
        for (int i=0;i<tokens.length;i++) {
          if (tokens[i] == 10) {
            operatorIth = i;
          } else if (tokens[i] == 11) {
            equalIth = i;
          }
        }

        // Skip impossible case
        if (operatorIth > equalIth
          || equalIth - operatorIth == 1
          || operatorIth == 0) return;

        // Construct multiplier, multiplicand and product
        int a = 0;
        for (int i=0;i<operatorIth;i++) a = a*10 + tokens[i];
        int b = 0;
        for (int i=operatorIth+1;i<equalIth;i++) b = b*10 + tokens[i];
        int c = 0;
        for (int i=equalIth+1;i<tokens.length;i++) c = c*10 + tokens[i];

        if (a*b == c) {
          ans.add(c);
        }
      }
    });

    // Find sum of all answers
    int sum = 0;
    for (int x : ans) {
      sum += x;
    }
    System.out.println(sum);
  }

}
