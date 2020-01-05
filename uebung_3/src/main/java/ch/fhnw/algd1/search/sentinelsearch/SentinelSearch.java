package ch.fhnw.algd1.search.sentinelsearch;

public class SentinelSearch {
    public static boolean exists(int[] data, int value) {
		int length = data.length;
		int last = data[length - 1];
        data[length - 1] = value;
        int i = 0;
        while (data[i] != value) {
            i++;
        }
        data[length - 1] = last;
        return (i < (length - 1)) || (value == data[length - 1]);
    }

    public static int firstIndex(int[] data, int value) {
        // TODO (A3 extra) Find first occurrence on an element in data (advanced challenge)
        return -1;
    }
}