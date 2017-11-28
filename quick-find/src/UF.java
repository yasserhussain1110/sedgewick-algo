import java.io.*;

public class UF {

  private final int[] id;

  public UF(int N) {
    id = new int[N];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public void union(int p, int q) {
    int pId = id[p];
    int qId = id[q];

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pId) {
        id[i] = qId;
      }
    }
  }

  public static void main(String args[]) {
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader(args[0]));

      int N = Integer.parseInt(br.readLine());
      UF uf = new UF(N);
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(" ");
        int p = Integer.parseInt(parts[0]);
        int q = Integer.parseInt(parts[1]);

        if (!uf.connected(p, q)) {
          uf.union(p, q);
          System.out.println(p + " " + q);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
