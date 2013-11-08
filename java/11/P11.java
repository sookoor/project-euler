


import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class P11 {

  public static void main(String[] args) throws IOException {

    Scanner scanner = null;
    int[][] data = new int[20][20];
    try {
      scanner = new Scanner(new File("input"));

      // Read data
      int col = 0;
      int row = 0;
      while (scanner.hasNextInt()) {
        if (col >= 20) {
          //System.out.println("");
          col = 0;
          row++;
        }
        data[row][col++] = scanner.nextInt();
        //System.out.print(data[row][col-1] + " ");
      }
    } finally {
      scanner.close();
    }

    long max = 0;

    for (int row = 0; row < 20; row++) {
      for (int col = 0; col <= 16; col++) {
        if (row < 16) {
          long m = data[row][col] * data[row][col+1] * data[row][col+2] * data[row][col+3];
          if (m > max) max = m;
          m = data[row][col] * data[row+1][col] * data[row+2][col] * data[row+3][col];
          if (m > max) max = m;
          m = data[row][col] * data[row+1][col+1] * data[row+2][col+2] * data[row+3][col+3];
          if (m > max) max = m;
        }
        if (row >= 3) {
          long m = data[row][col] * data[row-1][col+1] * data[row-2][col+2] * data[row-3][col+3];
          if (m > max) max = m;
        }
      }
    }

    System.out.println(max);
  }

}
