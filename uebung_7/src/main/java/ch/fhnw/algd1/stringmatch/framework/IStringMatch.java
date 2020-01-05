package ch.fhnw.algd1.stringmatch.framework;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface IStringMatch {
    /**
     * Returns position of first match or -1 if no match
     *
     * @param pattern
     * @param text
     * @return Match-Position or -1 in case of no match
     */
    int firstMatch(String text, String pattern);

    default void printInfo(String text, String pattern, int[] shift, int compares) {
        System.out.println("Text-Länge: " + text.length());
        System.out.println("Patter-Länge: " + pattern.length());
        System.out.println("Anzahl Vergleiche: " + compares);
		System.out.println("Vorkommensheuristik:");
        if (shift != null) {
            for (int i = 0; i < shift.length; i++) {
                char c = (char) i;
                if (i < 32) c = ' ';
                if (pattern.length() < 10) System.out.print(c + "|");
                else if (pattern.length() < 100) System.out.print(c + " |");
                else System.out.print(" " + c + " |");
            }
            System.out.println();
            for (int value : shift) {
                System.out.print(value + "|");
            }
            System.out.println();
        }

    }

    default void print(String text, String pattern, int i) {
        printWithPipes(text);
        System.out.println();
        char[] line = new char[text.length() * 2];
        Arrays.fill(line, '.');
        //System.out.println(new String(line));
        char[] spacesBefore = new char[i];
        Arrays.fill(spacesBefore, ' ');
        char[] spacesAfter = new char[text.length() - pattern.length() - i];
        Arrays.fill(spacesAfter, ' ');
        printWithPipes(new String(spacesBefore) + pattern + new String(spacesAfter));
        System.out.println();
        System.out.println(new String(line));
        System.out.println();
    }

    private void printWithPipes(String text) {
        char[] chars = text.toCharArray();
        Stream<Character> stream =
                IntStream.range(0, chars.length).mapToObj(c -> chars[c]);

        stream.forEach(c -> System.out.print(c + "|"));
    }
}
