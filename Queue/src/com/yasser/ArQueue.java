package com.yasser;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArQueue {
  private int startIndex = 0;
  private int endIndex = 0;
  private String[] strings;

  private static final int CAPACITY = 10;

  public ArQueue() {
    strings = new String[CAPACITY];
  }

  public void enqueue(String s) {
    strings[endIndex++] = s;

    if (endIndex >= strings.length && startIndex != 0) {
      reset();
    }
  }

  private void reset() {
    for (int i = startIndex; i < endIndex; i++) {
      strings[i - startIndex] = strings[i];
    }

    endIndex -= startIndex;
    startIndex = 0;
  }

  public String dequeue() {
    String val = strings[startIndex];
    strings[startIndex++] = null;
    return val;
  }

  public boolean isEmpty() {
    return startIndex == endIndex;
  }

  public static void main(String[] args) {
    String fileName = args[0];
    try {
      BufferedReader b = new BufferedReader(new FileReader(fileName));
      String line = b.readLine();
      b.close();
      String[] words = line.split(" ");
      ArQueue q = new ArQueue();
      for (String word : words) {
        if ("-".equals(word)) {
          System.out.println(q.dequeue());
        } else {
          q.enqueue(word);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
