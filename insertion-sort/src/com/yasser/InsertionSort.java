package com.yasser;

public class InsertionSort {
  public static void main(String[] args) {
    Integer[] numbers = {4, 2, 7, 8, 3, 1};
    sort(numbers);
    for (int n : numbers) {
      System.out.println(n);
    }
  }

  private static boolean less(Comparable item1, Comparable item2) {
    return item1.compareTo(item2) < 0;
  }

  private static void exchange(Comparable[] items, int i, int j) {
    Comparable swap = items[i];
    items[i] = items[j];
    items[j] = swap;
  }

  private static void sort(Comparable[] items) {
    for (int i = 0; i < items.length; i++) {
      for (int j = i; j > 0; j--) {
        if (less(items[j], items[j-1]))
          exchange(items, j, j-1);
        else break;
      }
    }
  }
}
