

import java.lang.Math;

class P4 {

  public static boolean is_palindome(int n) {
    if (n >= 100000) {
      // 6 digits
      int d6 = (n/100000);
      int d5 = (n/10000) % 10;
      int d4 = (n/1000) % 10;
      int d3 = (n/100) % 10;
      int d2 = (n/10) % 10;
      int d1 = n % 10;
      return (d6 == d1) && (d5 == d2) && (d4 == d3);
    } else {
      // 5 digits
      int d5 = (n/10000);
      int d4 = (n/1000) % 10;
      int d3 = (n/100) % 10;
      int d2 = (n/10) % 10;
      int d1 = n % 10;
      return (d5 == d1) && (d4 == d2);
    }
  }

  public static void main(String[] args) {
    int max = 0;

    for (int i=100;i<1000;i++) {
      for (int j=100;j<1000;j++) {
        int x = i*j;
        if (is_palindome(x) && x > max) {
          max = x;
        }
      }
    }

    System.out.println(max);
  }

}
