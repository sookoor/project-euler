

import java.util.*;
import java.util.regex.*;
import java.io.*;

class P22 {

  public static void main(String[] args) throws IOException {

    PriorityQueue<String> queue = new PriorityQueue<String>();

    // Read input
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("names.txt"));
      scanner.useDelimiter(",");
      Pattern p = Pattern.compile("\"([A-Z]+)\"");

      // Read data
      while (scanner.hasNext(p)) {
        scanner.next(p);
        String name = scanner.match().group(1);
        queue.add(name);
      }
    } finally {
      scanner.close();
    }

    int sum = 0;

    int ith = 1; 
    while (queue.size() != 0) {
      String name = queue.poll();

      for (int i =0;i<name.length();i++) {
        sum += (name.charAt(i) - 'A' + 1) * ith;
      }
      ith++;
    }


    System.out.println(sum);
  }

}
