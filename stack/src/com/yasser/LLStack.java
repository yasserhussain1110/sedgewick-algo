package com.yasser;

import java.io.BufferedReader;
import java.io.FileReader;

public class LLStack {
  private Node startNode = null;

  public String pop() {
    String currentVal = startNode.getValue();
    startNode = startNode.getNext();
    return currentVal;
  }

  public void push(String s) {
    startNode = new Node(s, startNode);
  }

  public boolean isEmpty() {
    return startNode == null;
  }

  public static void main(String[] args) {
    try {
      String fileName = args[0];
      BufferedReader b = new BufferedReader(new FileReader(fileName));
      String line = b.readLine();
      b.close();
      String[] words = line.split(" ");
      LLStack s = new LLStack();
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

  public static class Node {
    private String value;
    private Node next;

    public Node(String value, Node next) {
      this.value = value;
      this.next = next;
    }

    public String getValue() {
      return value;
    }

    public Node getNext() {
      return next;
    }
  }
}
