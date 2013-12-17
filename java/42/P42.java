

import java.util.*;
import java.util.regex.*;
import java.io.*;

class P42 {

  public static void main(String[] args) throws IOException {

    int ans = 0;

    // Read input
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("words.txt"));
      scanner.useDelimiter(",");
      Pattern p = Pattern.compile("\"([A-Z]+)\"");

      // Read data
      // Complexity: O(N) where N is the number of characters of all words
      while (scanner.hasNext(p)) {
        scanner.next(p);
        String name = scanner.match().group(1);

        // Check
        int sum = 0;
        int i = 0;
        do {
          if (i < name.length()) {
            char c = name.charAt(i);
            sum += c - 'A' + 1;
          }
          sum -= i+1;
          i++;
        } while (sum > 0 || i < name.length());

        if (sum == 0) {
          ans++;
        }
      }
    } finally {
      scanner.close();
    }

    System.out.println(ans);
  }

}
