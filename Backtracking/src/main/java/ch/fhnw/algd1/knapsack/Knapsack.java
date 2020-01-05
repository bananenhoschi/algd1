package ch.fhnw.algd1.knapsack;
/*
 * Created on Dec 12, 2013
 */

/**
 * @author Wolfgang Weck
 */
public final class Knapsack {
    private static final int[] weight = {7, 3, 5, 4}, value = {9, 2, 6, 4};
    private static final String[] data = {"\u25CF ", "\u25B2 ", "\u25C6 ", "\u25A0 "};
    private static final String[] dataNeg = {"\u25CB ", "\u25B3 ", "\u25C7 ", "\u25A1 "};
    private static final int capacity = 9;
    private static int totWeight, totValue, maxValue;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(maxValue());
    }

    private static int cnt = 0;

    private static int maxValue() {
        maxValue = 0;
        pack(0);
        return maxValue;
    }

    private static void pack(int i) {
        cnt++;
        if (i < weight.length) {
            sb.append(dataNeg[i]);
            pack(i + 1);
            sb.delete(sb.length() - dataNeg[i].length(), sb.length());
            packItem(i);
            pack(i + 1);
            unpackItem(i);
        } else if (totWeight <= capacity && totValue > maxValue) {
            maxValue = totValue;
            //System.out.println(".".repeat(cnt) + "new max value " + maxValue + " with weight " + totWeight);
        }

        if (sb.length() ==  8) System.out.println(sb);
        cnt--;
    }

    private static void packItem(int i) {
        totValue += value[i];
        totWeight += weight[i];
        sb.append(data[i]);
        // System.out.println(".".repeat(cnt) + "packing item " + i);
    }

    private static void unpackItem(int i) {
        totValue -= value[i];
        totWeight -= weight[i];
        sb.delete(sb.length() - data[i].length(), sb.length());
        // System.out.println(".".repeat(cnt) + "unpacking item " + i);
    }
}
