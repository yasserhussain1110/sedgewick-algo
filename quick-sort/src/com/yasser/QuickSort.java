package com.yasser;

public class QuickSort {
  public static void main(String[] args) {
    Integer[] nums = {7, 6, 5, 4, 3, 2, 1, 4};
    sort(nums);
    for (int n : nums) System.out.println(n);
  }

  public static void sort(Comparable[] items) {
    shuffle(items);
    sort(items, 0, items.length - 1);
  }

  public static void sort(Comparable[] items, int lo, int hi) {
    if (lo < hi) {
      int pivot = partition(items, lo, hi);
      sort(items, lo, pivot - 1);
      sort(items, pivot + 1, hi);
    }
  }

  public static int partition(Comparable[] items, int lo, int hi) {
    int pivot = lo;
    for (int i = lo; i <= hi; i++) {
      if (less(items[i], items[pivot])) {
        exchange(items, pivot + 1, i);
        exchange(items, pivot, pivot + 1);
        pivot++;
      }
    }
    return pivot;
  }

  public static boolean less(Comparable p, Comparable q) {
    return p.compareTo(q) < 0;
  }

  public static void shuffle(Object[] objects) {
    int N = objects.length;
    for (int i = 0; i < N; i++) {
      int p = rand(i, N);
      exchange(objects, i, p);
    }
  }

  public static void exchange(Object[] objects, int p, int q) {
    Object temp = objects[p];
    objects[p] = objects[q];
    objects[q] = temp;
  }

  public static int rand(int lo, int hi) {
    int range = hi - lo;
    return (int) (Math.random() * range) + lo;
  }
}

