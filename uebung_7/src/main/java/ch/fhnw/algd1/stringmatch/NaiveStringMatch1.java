package ch.fhnw.algd1.stringmatch;

import ch.fhnw.algd1.stringmatch.framework.IStringMatch;

public class NaiveStringMatch1 implements IStringMatch {

    private int compares;

    @Override
    public int firstMatch(String text, String pattern) {

        // sequential search for first i such that matches(text, i, pattern)
        for (int i = 0; i <= (text.length() - pattern.length()); i++) {
            print(text, pattern, i);

            if (matches(text, i, pattern)) {
                printInfo(text, pattern, null, compares);
                return i;
            }
        }
        printInfo(text, pattern, null, compares);

        return -1;
    }

    private boolean matches(String text, int start, String pattern) {
        // return if pattern matches text from position start
        for (int i = 0; i < pattern.length(); i++) {
            compares++;
            if (pattern.charAt(i) != text.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }
}