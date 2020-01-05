/*
 * Created on 21.03.2014
 */
package ch.fhnw.algd.sortalgs;

import ch.fhnw.algd.sortdemo.framework.SortAlg;
import ch.fhnw.algd.sortdemo.framework.SortData;

public class QuickSort implements SortAlg {
    @Override
    public void run(SortData data) {
        sort(data, 0, data.size() - 1);
    }


    private void sort(SortData a, int beg, int end) {

        if (beg < end) {
            int x = (beg + end) / 2;
            int i = beg, j = end;
            while (i <= j) {
                while (a.less(i, x)) i++;
                while (a.less(x, j)) j--;
                if (i <= j) {
                    a.swap(i, j);
                    if (i == x) {
                        x = j;
                    } else if (j == x) {
                        x = i;
                    }

                    ++i;
                    --j;
                }
            }
            sort(a, beg, j);
            sort(a, i, end);
        }
    }

}