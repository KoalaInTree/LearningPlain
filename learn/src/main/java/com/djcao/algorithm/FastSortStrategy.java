package com.djcao.algorithm;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/8/10
 */
public class FastSortStrategy extends AbstractSortStrategy implements SortStrategy{
    @Override
    public void sort(Comparable[] a) {
        sortInner(a, 0, a.length - 1);
    }

    public void sortInner(Comparable[] a, int low, int hi) {
        if (low >= hi)
            return;
        int mid = (low + hi) / 2;
        Comparable midValue = a[mid];
        int left = low, right = hi;
        while (left <= right) {
            while (left <= right && less(a[left],midValue))
                left++;

            while (left <= right && lessAndEq(midValue,a[right]))
                right--;

            if (left <= right) {
                Comparable tmp = a[left];
                a[left++] = a[right];
                a[right--] = tmp;
            }
        }
        sortInner(a, low, mid);
        sortInner(a, mid + 1, hi);
    }

}
