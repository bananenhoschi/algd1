package ch.fhnw.algd1.gcd;

import ch.fhnw.algd1.gcd.framework.IGcd;

public class GcdIter implements IGcd {

    @Override
    public int gcd(int x, int y) {
        // TODO (A4a) implement computation of gcd in a loop

        while (x != y) {
            if (x > y) x = x - y;
            else y = y - x;
        }
        return x;
    }

}
