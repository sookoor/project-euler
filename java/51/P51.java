

import java.lang.Math;
import java.util.*;

class P51 {

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


  /**
   * Count digits of the number
   *
   * Complexity: O(d)
   */
  public static int countDigits(int n) {
    int d = 0;
    while(n>0) {
      n = n/10;
      d++;
    }
    return d;
  }

  public static int digitAt(int n, int i) {
    return (n / pow10(i))%10;
  }

  public static int pow10(int i) {
    int x = 1;
    switch(i) {
      case 10: x *= 10;
      case 9: x *= 10;
      case 8: x *= 10;
      case 7: x *= 10;
      case 6: x *= 10;
      case 5: x *= 10;
      case 4: x *= 10;
      case 3: x *= 10;
      case 2: x *= 10;
      case 1: x *= 10;
      default: return x;
    }
  }

  /**
   * Check is in prime family
   *
   * Complexity: O(d^4)
   */
  public static boolean isInPrimeFamily(int n, int familySize) {
    int d = countDigits(n);

    // select 2 digits
    LinkedList<Integer> digits = new LinkedList<Integer>();

    for (int i=0;i<d-1;i++) {
      int a = digitAt(n, i);
      if (10-a < familySize) continue;

      digits.add(i);

      for (int j=i+1;j<d;j++) {
        if (a == digitAt(n, j)) {

          digits.add(j);
          int fs = familySize-1;
          for (int t=a+1;t<10;t++) {
            int x = n;
            for (int ith : digits) {
              x = x - (a - t)*pow10(ith);
            }
            if (isPrime(x)) {
              fs--;
            }
          }
          if (fs == 0) return true;
        }
      }

      digits.clear();
    }

    return false;
  }

  public static void main(String[] args) {

    // Complexity: O(Nd^4) where N is limit and d is the digits of the number
    int ans = 0;
    for (int n=1;;n++) {
      if (isPrime(n) && isInPrimeFamily(n, 8)) {
        ans = n;
        break;
      }
    }

    System.out.println(ans);
  }

}
