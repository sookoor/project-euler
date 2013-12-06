


import java.lang.Math;
import java.util.*;

class P33 {

  public static int gcd(int a ,int b) {
    if (a == 0) return b;
    if (b == 0) return a;
    return (a>b)? gcd(b, a-b) : gcd(a, b-a);
  }

  public static void main(String[] args) {
    int prodA = 1;
    int prodB = 1;

    // Complexity: O(N^2) where N is number of possible nemerator or denominator
    for (int a = 10;a<100;a++) {
      for (int b = a+1;b<100;b++) {
        double v = 0.00;
        if (a/10 == b/10) {
          v = (a%10) * 1.00 / (b%10);
        } else if (a/10 == b%10) {
          v = (a%10) * 1.00 / (b/10);
        } else if (a%10 == b/10) {
          v = (a/10) * 1.00 / (b%10);
        } else if (a%10 == b%10 && a%10 != 0) {
          v = (a/10) * 1.00 / (b/10);
        }
        if (v > 0.00 && v == a*1.0/b) {
          prodA *= a;
          prodB *= b;
        }
      }
    }

    int g = gcd(prodA, prodB);

    System.out.println(prodB/g);
  }

}
