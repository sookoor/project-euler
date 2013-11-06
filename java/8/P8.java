

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

class P8 {

  public static void main(String[] args) throws IOException {

    FileReader reader = null;
    int max = 0;
    try {
      reader = new FileReader("input");

      int c = 0;
      int n = 0;
      int p = 1;
      int zero = 0;
      LinkedList<Integer> p5 = new LinkedList<Integer>();

      // Complexity: O(N)
      while ((c = reader.read()) > 0) {
        if (c < '0' || c > '9') continue; // filter non-number out
        c -= '0'; // convert to normal int

        if (c == 0) {
          zero = 4; // next 4 charactor the value is zero
        } else {
          p *= c; // multiply to current product
        }

        if (p5.size() == 5) {
          int prev = p5.removeFirst();
          if (prev > 0) {
            p = p / prev; // divide the the last 6th out of the product
          }
        }
        p5.add(c);

        if (zero == 0 && p > max) {
          max = p;
        } else if (zero > 0) {
          zero--;
        }
      }

    } finally {
      reader.close();
    }


    System.out.println(max);
  }

}
