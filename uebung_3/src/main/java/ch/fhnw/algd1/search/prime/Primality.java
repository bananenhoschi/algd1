package ch.fhnw.algd1.search.prime;

public class Primality {
    public static boolean isPrime(int x) {
        int t = (x - 1);
        while (t > 1) {
            if (x % t == 0) return false;
            t--;
        }
        return true;
    }
}
