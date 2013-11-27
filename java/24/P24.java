


import java.util.*;

class P24 {

  public static void swap(StringBuilder str, int a, int b) {
    char c = str.charAt(a);
    str.setCharAt(a, str.charAt(b));
    str.setCharAt(b, c);
  }

  /**
   * Permutate this string in lexicographical order nth times
   *
   * Complexity: O(N^N) which N is number of digits
   */
  public static int permutate(StringBuilder str,int start, int n) {
    if (start == str.length()-1) {
      return n-1;
    }

    // permutate the rest
    n = permutate(str, start+1, n);
    if (n == 0) {
      return 0;
    }

    // pick next greater to lead
    for (int i = start+1;i<str.length();i++) {
      // swap greater to lead
      for (int j = i;start < j;j--) {
        swap(str, j-1, j);
      }

      // permutate the rest
      n = permutate(str, start+1, n);
      if (n == 0) {
        return 0;
      }

      // swap back
      for (int j = start;j < i;j++) {
        swap(str, j, j+1);
      }
    }

    return n;
  }

  public static void main(String[] args) {
    StringBuilder str = new StringBuilder("0123456789");

    int nth = 1000000;

    // Complexity: O(N^N) which n is number of digits
    permutate(str, 0, nth);

    System.out.println(str);
  }

}
