


import java.lang.Math;

class P12 {

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

  public static long triangleNum(int i) {
    return (i)*(i+1)/2;
  }

  public static boolean factorOverLimit(long n, int limit) {
    int factor_n = 0;
    if (isPrime(n)) return false;

    for (int i=1;i<Math.floor(Math.sqrt(n));i++) {
      if (n % i == 0) {
        factor_n += 2;
        if (factor_n > limit) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {


    // Complexity O(N^2)
    int i = 1;
    long n = 0;
    do {
      n = triangleNum(i++);
    } while(!factorOverLimit(n, 500));


    System.out.println(n);
  }

}
