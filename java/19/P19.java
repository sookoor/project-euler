

class P19 {

  /**
   * Number of days of the specific month and year
   *
   * Complexity: O(1)
   */
  public static int daysOfMonth(int m, int year) {
    boolean isLeap = (year%4==0) && (year%100!=0 || year%400==0);

    switch(m) {
      case 2:
        return (isLeap)? 29:28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  public static void main(String[] args) {

    int n = 0;
    int d = 0;
    for (int y=1900; y<=2000;y++) {
      for (int m=1;m<=12;m++) {
        d += daysOfMonth(m, y);
        d = d % 7;
        if (d == 6 && y >= 1901) {
          n++;
        }
      }
    }

    System.out.println(n);
  }

}
