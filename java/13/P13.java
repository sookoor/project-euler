



import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class P13 {

  public static void add(int[] d, int pos, int v) {
    int x = d[pos] + v;
    if (x >= 10) {
      d[pos] = x%10;
      add(d, pos+1, x/10);
    } else {
      d[pos] = x;
    }
  }

  public static void main(String[] args) throws IOException {

    Scanner scanner = null;
    int[] sum = new int[55];
    try {
      scanner = new Scanner(new File("input"));

      // Read data
      while (scanner.hasNextLine()) {
        String d = scanner.nextLine();
        for (int i=d.length();i>0;i--) {
          add(sum, d.length() - i, d.charAt(i-1) - '0');
        }
      }
    } finally {
      scanner.close();
    }

    int n=10;
    boolean leadingZero = true;
    for (int i=sum.length-1;i>=0 && n > 0;i--) {
      if (sum[i] == 0 && leadingZero) {
        continue;
      }
      leadingZero = false;
      n--;
      System.out.print(sum[i]);
    }

    System.out.println("");
  }

}
