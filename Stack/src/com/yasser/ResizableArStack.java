package com.yasser;

import java.io.BufferedReader;
import java.io.FileReader;

public class ResizableArStack {
  private String[] strings;
  private int N = 0;

  public ResizableArStack() {
    strings = new String[1];
  }

  public void push(String s) {
    strings[N++] = s;
    if (N >= strings.length) {
      resize(2 * strings.length);
    }
  }

  public String pop() {
    String value = strings[--N];
    strings[N] = null;

    if (N != 0 && N * 4 <= strings.length) resize(strings.length / 2);

    return value;
  }

  private void resize(int newCapacity) {
    String[] newStringArray = new String[newCapacity];

    for (int i = 0; i < N; i++) newStringArray[i] = strings[i];

    strings = newStringArray;
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
      ResizableArStack s = new ResizableArStack();
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
