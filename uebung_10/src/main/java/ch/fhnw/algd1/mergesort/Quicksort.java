package ch.fhnw.algd1.mergesort;

import java.util.Arrays;

public class Quicksort {


    public static void main(String[] args) {

        int[] a = {31, 12, 12, 28, 42, 5, 7};
        sort(a, 0, a.length-1);

    }


    static void sort(int[] a, int beg, int end) {

        if (beg < end) {
            int x = a[(beg + end) / 2];
            int i = beg;
            int j = end;

            while (i <= j) {
                while (a[i] < x) i++;
                while (a[j] > x) j--;
                if (i <= j) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    i++;
                    j--;

                }
            }
            sort(a, beg, j);
            sort(a, i, end);
        }
    }
}
