

class P2 {

  public static void main(String[] args) {
    /**
     * an = an-1 + an-2;
     * an+1 = an + an-1;
     * an+2 = an+1 + an;
     * an+3 = an+2 + an+1;
     * an+3 = 2(an+1) + an
     * an+4 = an+3 + an+1 + an
     */

    int max = 4000000;
    int an_plus_1 = 3;
    int an = 2;
    long ans = 0;
    while (an <= max) {
      ans += an;
      int an_plus_3 = 2*an_plus_1 + an;
      int an_plus_4 = an_plus_3 + an_plus_1 + an;
      an = an_plus_3;
      an_plus_1 = an_plus_4;
    }
    System.out.println(ans);
  }

}
