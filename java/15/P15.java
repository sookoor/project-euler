

import java.util.HashMap;

class P15 {

  /**
   * Top-down dynamic programming approach
   * Complexity: O(2^n) with memoization
   */
  public static long move(int down, int right, long[][] mem) {
    if (down == 0 && right == 0) return 1;
    if (down < 0 || right < 0) return 0;
    if (mem == null) mem = new long[down][right];
    else if (mem[down-1][right-1] > 0) return mem[down-1][right-1];

    long n = move(down-1, right, mem) + move(down, right-1, mem);
    mem[down-1][right-1] = n;
    return n;
  }

  /**
   * Bottom-up dynamic programming approach
   * Complexity: O(n^2)
   */
  public static long move(int down, int right) {
    long[][] m = new long[down+1][right+1];
    for (int i=0;i<=down;i++) m[i][0] = 1L;
    for (int i=0;i<=right;i++) m[0][i] = 1L;

    for (int i=1;i<=down;i++) {
      for (int j=1;j<=right;j++) {
        m[i][j] = m[i-1][j] + m[i][j-1];
      }
    }

    return m[down][right];
  }

  public static void main(String[] args) {
    System.out.println(move(20, 20));
    System.out.println(move(20, 20));
  }

}
