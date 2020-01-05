package ch.fhnw.algd1.maxsubsequence;

public class MaxSubProblem {

    public int maxSub(int[] data) {


        int size = data.length;
        int max_so_far = Math.max(data[0], 0), max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + data[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

}
