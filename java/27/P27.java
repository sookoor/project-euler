


import java.lang.Math;
import java.util.*;

class P27 {

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

    int limit = 1000;

    int ansA = 0;
    int ansB = 0;
    int max = 0;

    for (int a = 1-limit; a<limit;a++) {
      for (int b = 1-limit; b<limit;b++) {
        int n = 0;
        while (isPrime(Math.abs(n*n + a*n + b))) {
          n++;
        }
        if (n > max) {
          max = n;
          ansA = a;
          ansB = b;
        }
      }
    }

    System.out.println(ansA * ansB);
  }

}
