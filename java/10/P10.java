

import java.lang.Math;

class P10 {

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

    long nextPrime = 5L;
    long sum = 5;

    // Complexity O(N^2)
    while (nextPrime < 2000000) {
      if (isPrime(nextPrime)) {
        sum += nextPrime;
      }
      nextPrime += 2;
    }

    System.out.println(sum);
  }

}
