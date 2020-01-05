package ch.fhnw.algd1.countup;

public class Countup {

    public static void main(String[] args) {
        countup(10);
    }

    private static void countup(int n) {
        if (n > 0)
            countup(n - 1);
        System.out.println("Countup... " + n);
    }

}
