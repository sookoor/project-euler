
import java.util.HashMap;

class P14 {

  public static int chainOf(long i, HashMap<Long,Integer> map) {
    if (i == 1) return 1;
    if (map.containsKey(i)) return map.get(i);

    int chain = 0;
    if (i%2 == 0) {
      chain = chainOf(i/2, map) + 1;
    } else {
      chain = chainOf(3*i+1, map) + 1;
    }
    map.put(i, chain);

    return chain;
  }


  public static void main(String[] args) {

    // Memoization
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();

    int maxChain = 0;
    int maxNumber = 0;
    // Complexity: O(NLogN)
    for (int i=13;i<1000000;i++) {

      int chain = chainOf((long)i, map);

      if (chain > maxChain) {
        maxChain = chain;
        maxNumber = i;
      }
    }

    System.out.println(maxNumber);
  }

}
