package ch.fhnw.algd1.stringmatch;

import ch.fhnw.algd1.stringmatch.framework.IStringMatch;

import java.util.Arrays;

/**
 * Boyer-Moore-Horspool String Match (supporting LATIN-1 character set)
 */
public class BoyerMooreHorspoolStringMatch implements IStringMatch {

    private int compares;

    private int[] allShifts(String pattern) {
        int[] shift = new int[256]; // we support the LATIN-1 character set

        int l = pattern.length();
        Arrays.fill(shift, l);
        for (int i = 0; i < l - 1; i++) {
            shift[pattern.charAt(i)] = l - 1 - i;
        }
        return shift;
    }

    @Override
    public int firstMatch(String text, String pattern) {

        int[] shift = allShifts(pattern);

        int l = pattern.length(), i = 0, j = l - 1; // Warum?
        while (i + l <= text.length() && j >= 0) {

            print(text, pattern, i);

            j = l - 1; // Warum?

            while (j >= 0 && pattern.charAt(j) == text.charAt(i + j)) {
                compares++;
                j--;
            }

            if (j >= 0) {
                compares++;
                i = i + shift[text.charAt(i + l - 1)];
            }
        }
        printInfo(text, pattern, shift, compares);

        return (i + l <= text.length()) ? i : -1;
    }

}
