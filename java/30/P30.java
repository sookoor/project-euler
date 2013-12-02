


import java.lang.Math;
import java.util.*;

class P30 {

  public static void main(String[] args) {

    int n = 100;

    int allSum = 0;

    for (int i=2;i<=1000000;i++) {
      int x = i;
      int sum = 0;
      while (x > 0) {
        int r = x%10;
        sum += Math.pow(r, 5);
        x = (x-r)/10;
      }

      if (sum == i) {
        allSum += sum;
      }
    }


    System.out.println(allSum);
  }

}
