package ch.fhnw.algd1.stringmatch;

import ch.fhnw.algd1.stringmatch.framework.IStringMatch;

public class NaiveStringMatch2 implements IStringMatch {
    @Override
    public int firstMatch(String text, String pattern) {
        // TODO (A3) search for first start position i where pattern matches text

        for (int i = 0; i <= (text.length() - pattern.length()); i++) {
        	int j = 0;
			print(text, pattern, i);

			while (j < pattern.length() && pattern.charAt(j) == text.charAt(i+j)){
        		j++;
			}
        	if(j == pattern.length()){
        		return i;
			}
        }
        return -1;
    }
}