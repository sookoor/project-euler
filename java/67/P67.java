
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class P67 {

  /**
   * Dynamic programming bottom-up approach
   *
   * Complexity: O(n^2) which n is number of row
   */
  public static int maxSum(int[][] data) {

    int row = data.length;
    for(int r = data.length-1;r>0;r--) {
      for (int c = 0;c < r;c++) {
        int max = (data[r][c] > data[r][c+1])? data[r][c]: data[r][c+1];
        data[r-1][c] += max;
      }
    }

    return data[0][0];
  }

  public static void main(String[] args) throws IOException {

    int ROW = 100;
    int[][] data = new int[ROW][ROW];

    // Read input
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("input"));

      // Read data
      int max = 1;
      int i = 0;
      while (scanner.hasNextInt()) {
        int n = scanner.nextInt();

        data[max-1][i++] = n;
        if (i >= max) {
          max += 1;
          i = 0;
        }
      }
    } finally {
      scanner.close();
    }

    int sum = maxSum(data);
    System.out.println(sum);
  }

}
