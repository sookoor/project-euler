


class P6 {

  public static void main(String[] args) {
    // square of sum = (1 + 2 + 3) * (1 + 2 +3) = 1^2 + 1*2 + 1*3 + 2*1 + 2^2 + 2*3 + 3*1 + 3*2 + 3^2
    // sum of square = 1^2 + 2^2 + 3^2
    // difference is 2(1*2) + 2(1*3) + 2(2*3)

    int n = 100;

    // Complexity: O(N^2)
    long ans = 0;
    for (int i = 1; i<= n; i++) {
      for (int j = i+1; j<= n; j++) {
        ans += i*j*2;
      }
    }

    System.out.println(ans);
  }

}
