
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class P18 {

  /**
   * Data structure for the tree
   */
  static class Node {

    public final int val;
    public Node left;
    public Node right;

    public Node(int v, Node l, Node r) {
      this.val = v;
      this.left = l;
      this.right = r;
    }

  }


  /**
   * Print tree
   *
   * Complexity: O(n^2) which n is number of row
   */
  public static void print(Node root) {
    LinkedList<Node> list = new LinkedList<Node>();
    list.add(root);
    int max = list.size();
    while (list.size() > 0) {
      Node n = list.poll();
      System.out.print(n.val+" ");

      if (n.left != null) {
        list.add(n.left);
      }

      if (--max == 0) {
        if (n.right != null) {
          list.add(n.right);
        }
        System.out.println("");
        max = list.size();
      }
    }
  }

  /**
   * Recursrive sum weight of each path
   *
   * Complexity: O(2^n) which n is number of row
   */
  public static int weight(Node n) {
    if (n == null) return 0;

    int left = 0;
    int right = 0;
    if (n.left != null) left = weight(n.left);
    if (n.right != null) right = weight(n.right);

    return n.val + ((left > right)? left:right);
  }

  public static void main(String[] args) throws IOException {

    Node root = null;
    LinkedList<Node> cur = new LinkedList<Node>();
    LinkedList<Node> next = new LinkedList<Node>();

    // Read input
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File("input"));

      // Read data
      while (scanner.hasNextInt()) {
        Node n = new Node(scanner.nextInt(), null, null);
        if (root == null) {
          root = n;
        }

        next.add(n);

        if (cur.size() != 0) {
          Node curNode = cur.getFirst();
          if (curNode.left == null) {
            curNode.left = n;
          } else {
            curNode.right = n;
            cur.poll();
            if (cur.size() > 0) {
              cur.getFirst().left = n;
            }
          }
        }

        if (cur.size() == 0) {
          LinkedList<Node> t = cur;
          cur = next;
          next = t;
        }
      }
    } finally {
      scanner.close();
    }

    int sum = weight(root);
    System.out.println(sum);
  }

}
