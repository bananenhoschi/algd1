package ch.fhnw.algd1.converters.binary;

import java.util.stream.Stream;

public class BinConverter {

    public static String toString(int x) {
        // digits representing x in 2-complement
        String s = "";
        if (x < 0) {
            x = 256 + x;
        }

        while (x > 0) {
            s = (x % 2) + s;
            x = x >> 1;
        }
        while (s.length() < 8) s = "0" + s;
        return s;
    }

    public static int fromString(String text) {
        // TODO expect text to contain 8 binary digits, parse to int value in
        // 2-complement
        char[] chars = text.toCharArray();
        int msb = chars[0] == '1' ? -128 : 0;
        int val = 0;
        int e = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == 49)
                val += Math.pow(2, e);
            e = e + 1;
        }

        return msb + val;
    }
}