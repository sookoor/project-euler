


import java.util.*;

class P28 {

  public static void main(String[] args) {

    int n = 1001;
    int step = 2;
    int level = 4;

    int sum = 1;
    for (long i=3;i<=n*n;i+=step) {
      sum += i;
      if (--level == 0) {
        step += 2;
        level = 4;
      }
    }

    System.out.println(sum);
  }

}
