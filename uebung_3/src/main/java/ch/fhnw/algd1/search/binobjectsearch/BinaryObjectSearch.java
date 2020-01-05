package ch.fhnw.algd1.search.binobjectsearch;

public class BinaryObjectSearch {
    public static final int NOT_FOUND = -1;

    public static <T extends Comparable<? super T>> int binSearch(T[] data, T value) {
        int l = -1;
        int h = data.length;
        while (l + 1 != h) {
            int m = l + ((h - l) / 2);
            if (data[m].compareTo(value) < 0)
                l = m;
            else if (data[m].compareTo(value) > 0)
                h = m;
            else return m;
        }
        return NOT_FOUND;
    }
}
