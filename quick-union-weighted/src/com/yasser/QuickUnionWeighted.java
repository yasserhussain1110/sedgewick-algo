package com.yasser;

import java.io.BufferedReader;
import java.io.FileReader;

public class QuickUnionWeighted {
  private final int[] id;
  private final int[] weight;

  public QuickUnionWeighted(int N) {
    id = new int[N];
    weight = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      weight[i] = 1;
    }
  }

//  private int findRoot(int p) {
//    int temp = p;
//    while (id[temp] != temp) {
//      // Imperfect path compression. Linking node to its grand-parent.
//      id[temp] = id[id[temp]];
//      temp = id[temp];
//    }
//    return temp;
//  }

  /* Perfect path compression */
  private int findRoot(int p) {
    int temp = p;
    while (id[temp] != temp) {
      temp = id[temp];
    }

    int root = temp;

    temp = p;
    while (id[temp] != temp) {
      int parent = id[temp];
      id[temp] = root;
      temp = parent;
    }
    return root;
  }

  public boolean connected(int p, int q) {
    return findRoot(p) == findRoot(q);
  }

  public void union(int p, int q) {
    int qId = findRoot(q);
    int pId = findRoot(p);
    if (weight[qId] > weight[pId]) {
      id[pId] = qId;
      weight[qId] += weight[pId];
    } else {
      id[qId] = pId;
      weight[pId] += weight[qId];
    }
  }

  public static void main(String[] args) {
    try {
      BufferedReader b = new BufferedReader(new FileReader(args[0]));
      int numberOfNodes = Integer.parseInt(b.readLine());
      QuickUnionWeighted quw = new QuickUnionWeighted(numberOfNodes);
      String line;
      while ((line = b.readLine()) != null) {
        String nums[] = line.split(" ");
        int p = Integer.parseInt(nums[0]);
        int q = Integer.parseInt(nums[1]);
        if (!quw.connected(p, q)) {
          quw.union(p, q);
          System.out.println(p + " " + q);
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
