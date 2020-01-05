package ch.fhnw.algd1.gcd;

import ch.fhnw.algd1.gcd.framework.IGcd;

public class GcdRec implements IGcd {

    @Override
    public int gcd(int x, int y) {
        // TODO (A4c) implement computation of gcd based on recursive calls
		if(x == y) return x;
        if (x > y) return gcd(x - y, y);
        else return gcd(x, y - x);
    }

}
