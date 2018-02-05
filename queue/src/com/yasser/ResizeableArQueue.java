package com.yasser;

import java.io.BufferedReader;
import java.io.FileReader;

public class ResizeableArQueue {
  private int startIndex = 0;
  private int endIndex = 0;
  private String[] strings;

  public ResizeableArQueue() {
    strings = new String[1];
  }

  public void enqueue(String s) {
    strings[endIndex++] = s;

    if (endIndex >= strings.length) {
      if (startIndex == 0) {
        resize(strings.length * 2);
      } else {
        reset();
      }
    }
  }

  private void reset() {
    for (int i = startIndex; i < endIndex; i++) {
      strings[i-startIndex] = strings[i];
    }

    endIndex -= startIndex;
    startIndex = 0;
  }

  private void resize(int newCapacity) {
    String[] newStringArray = new String[newCapacity];

    for (int i = startIndex; i < endIndex; i++) {
      newStringArray[i-startIndex] = strings[i];
    }

    strings = newStringArray;
    endIndex -= startIndex;
    startIndex = 0;
  }

  public String dequeue() {
    String value = strings[startIndex];
    strings[startIndex++] = null;

    if ((endIndex - startIndex) <= strings.length / 4) {
      resize(strings.length / 2);
    }

    return value;
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
      ResizeableArQueue q = new ResizeableArQueue();
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
