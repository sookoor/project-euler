


import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

class P9 {

  public static void main(String[] args) throws IOException {

    // a^2 + 2ab + b^2 = 1000^2 - 2000c + c^2
    // 2ab = 1000^2 - 2000c
    // abc = 500*1000c - 1000c^2
    // abc = (1000c)(500 - c)
    //
    // c < 500
    //
    // a + b + c = 1000 and a < b < c
    // then c > 333

    for (int c = 334; c < 500; c++) {
      for (int b = (1000-c)/2; b < c; b++) {
        int a = 1000 - b - c;
        if (a*a + b*b == c*c) {
          System.out.println(a*b*c);
        }
      }
    }

  }

}
