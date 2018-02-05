package com.yasser;

public class SelectionSort {
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


  public static void sort(Comparable[] items) {
    for (int i = 0; i < items.length; i++) {
      int min = i;
      for (int j = i; j < items.length; j++) {
        if (less(items[j], items[min])) min = j;
      }
      exchange(items, i, min);
    }
  }
}
