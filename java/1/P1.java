
class P1 {

  public static int sum_series(int m, int max) {
    return (m*(1+(max/m))*(max/m))/2;
  }

  public static void main(String[] args) {
    int max = 999; // below 1000
    int ans = sum_series(3,max) + sum_series(5,max) - sum_series(15, max);
    System.out.println(ans);
  }

}
