package ch.fhnw.algd1.springer;


public class SpringerProblem {


    public static void main(String[] args) {
        SpringerAlgo springerAlgo = new SpringerAlgo();
        if (springerAlgo.move(0, 0, 1)) {
            System.out.println("Solved!");
        }

    }


}
