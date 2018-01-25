package com.yasser;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArStack {
  private String[] strings;
  private int N = 0;
  private static final int CAPACITY = 10;

  public ArStack() {
    strings = new String[CAPACITY];
  }

  public void push(String s) {
    strings[N++] = s;
  }

  public String pop() {
    String value = strings[--N];
    strings[N] = null;
    return value;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public static void main(String[] args) {
    try {
      String fileName = args[0];
      BufferedReader b = new BufferedReader(new FileReader(fileName));
      String line = b.readLine();
      b.close();
      String[] words = line.split(" ");
      ArStack s = new ArStack();
      for (String word : words) {
        if ("-".equals(word)) {
          System.out.println(s.pop());
        } else {
          s.push(word);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
