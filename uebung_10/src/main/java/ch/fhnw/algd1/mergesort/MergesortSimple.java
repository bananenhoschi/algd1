package ch.fhnw.algd1.mergesort;

public class MergesortSimple {
    public void mergesort(int[] a) {
        sort(a, 0, a.length);
    }

    private void sort(int[] a, int beg, int end) {

        if (end - beg > 1) {
            int m = (beg + end) >>> 1;
            sort(a, beg, m);
            sort(a, m, end);
            merge(a, beg, m, end);
        }
    }

    // Merges sequence a[beg...m-1] with a[m...end-1] into a[beg...end-1]
    private void merge(int[] a, int beg, int m, int end) {
        int[] b = new int[end - beg];

        int i = 0, j = beg, k = m;
        while (j < m && k < end) {
            if (a[j] <= a[k]) b[i++] = a[j++];
            else b[i++] = a[k++];
        }
        while (j < m) {
            b[i++] = a[j++];
        }
        while (i > 0) {
            --i;
            a[beg + i] = b[i];
        }
    }
}
