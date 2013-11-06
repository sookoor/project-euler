

class P5 {

  /**
   * Factorize n and check with factor array.
   *
   * @param factor accumulated factors which index is factor-1 and value is power of the factor.
   * @param n the number to be factorized.
   * @param limit the upper bound of factor number.
   * @return the multipication of additional factor which introduce to factor array this time.
   */
  public static long factorize(int[] factor, int n, int limit) {
    int f = 2;
    int m = 0;
    int ans = 1;
    while (f <= factor.length && n > 1 && f <= limit) {
      if (n % f == 0) {
        m++;
        if (m > factor[f-1]) {
          factor[f-1] = m;
          ans *= f;
        }
        n = n / f;
      } else {
        m = 0;
        f++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 20;
    long ans = 2520;
    int limit = 10;

    int[] factor = new int[n];
    ans = factorize(factor, (int) ans, limit);

    for (int i = limit+1; i<= n; i++) {
      ans = ans * factorize(factor, i, i);
    }

    System.out.println(ans);
  }

}
