package com.yasser;

public class ShellSort {

  public static void main(String[] args) {
    Integer[] numbers = {12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 13, 17, 21, 26, 35, 32, 78, 65, 44};
    sort(numbers);

    for (int n : numbers) System.out.println(n);
  }

  public static boolean less(Comparable item1, Comparable item2) {
    return item1.compareTo(item2) < 0;
  }

  public static void exchange(Comparable[] items, int i, int j) {
    Comparable swap = items[i];
    items[i] = items[j];
    items[j] = swap;
  }

  public static void sort(Comparable[] items) {
    int N = items.length;
    int h = 1;

    while (h < N / 3) h = h * 3 + 1;

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h; j-=h) {
          if (less(items[j], items[j - h])) {
            exchange(items, j, j - h);
          } else {
            break;
          }
        }
      }
      h = h / 3;
    }

  }
}
