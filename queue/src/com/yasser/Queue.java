package com.yasser;

import java.io.BufferedReader;
import java.io.FileReader;

public class Queue {
  private Node startNode = null;
  private Node endNode = null;

  public void enqueue(String value) {
    if (isEmpty()) {
      startNode = endNode = new Node(value);
    } else {
      endNode.setNext(new Node(value));
      endNode = endNode.getNext();
    }
  }

  public String dequeue() {
    String value = startNode.getValue();
    startNode = startNode.getNext();
    if (isEmpty()) endNode = null;
    return value;
  }

  public boolean isEmpty() {
    return startNode == null;
  }

  public static void main(String[] args) {
    String fileName = args[0];
    try {
      BufferedReader b = new BufferedReader(new FileReader(fileName));
      String line = b.readLine();
      b.close();
      String[] words = line.split(" ");
      Queue q = new Queue();
      for (String word : words) {
        if ("-".equals(word)) {
          System.out.println(q.dequeue());
        } else {
          q.enqueue(word);
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static class Node {
    private String value;
    private Node next;

    public Node(String value) {
      this(value, null);
    }

    public Node(String value, Node next) {
      this.value = value;
      this.next = next;
    }

    public void setNext(Node next) {
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
